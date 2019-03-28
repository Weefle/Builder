package org.anhcraft.spaciouslib.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.anhcraft.spaciouslib.annotations.DataField;
import org.anhcraft.spaciouslib.annotations.Serializable;
import org.anhcraft.spaciouslib.builders.ArrayBuilder;
import org.anhcraft.spaciouslib.builders.EqualsBuilder;
import org.anhcraft.spaciouslib.builders.HashCodeBuilder;

/**
 * Represents a table which divides its elements by rows and columns.
 * @param <E> the type of elements in this table
 */
@Serializable
public class Table<E> {
    @DataField
    protected E[][] data;
    @DataField
    protected int column;
    @DataField
    protected int row;
    @DataField
    protected long remain;
    @DataField
    protected long lastEmptySlot;

    /**
     * Creates a new table
     * @param column number of columns
     * @param row number of rows
     */
    public Table(int column, int row){
        this.column = column;
        this.row = row;
        this.remain = row*column;
        this.lastEmptySlot = 0;
        this.data = (E[][]) new Object[column][row];
    }

    /**
     * Clones an existing table
     * @param table existing table
     */
    public Table(Table<E> table){
        this.column = table.column;
        this.row = table.row;
        this.data = table.data;
        this.remain = table.remain;
        this.lastEmptySlot = table.lastEmptySlot;
    }

    /**
     * Insert all given entries into the table.<br>
     * When a row which is being adding is full, existing entries will be broke and fill into next rows. But if the limit is reached, this method will throw an exception
     * @param objs an array of objects
     */
    public void insert(E... objs){
        ExceptionThrower.ifTrue(lastEmptySlot == -1, new Exception("No empty entries in the table"));
        ExceptionThrower.ifTrue(remain < objs.length, new Exception("Number of entries is out of bound"));
        // reduce checking times by saving the last empty entries from the previous check
        long i = lastEmptySlot;
        int j = 0;
        while(i < size()){
            // put each entry into the table
            if(j < objs.length) {
                if(get(i) == null) {
                    Group<Integer, Integer> pos = posCoords(i);
                    data[pos.getA()][pos.getB()] = objs[j];
                    remain--;
                    j++;
                }
            }
            // after the adding is done, we move to the empty-entry-checking step
            else {
                if(remain > 0) {
                    if(get(i) == null) {
                        lastEmptySlot = i;
                        break;
                    }
                } else {
                    lastEmptySlot = -1;
                    break;
                }
            }
            i++;
        }
    }

    /**
     * Overrides object of a specific entry
     * @param index the index
     * @param obj new object
     */
    public void set(long index, E obj){
        ExceptionThrower.ifTrue(index > size(), new Exception("Number of entries is out of bound (index="+index+")"));
        Group<Integer, Integer> pos = posCoords(index);
        data[pos.getA()][pos.getB()] = obj;
    }

    /**
     * Overrides object of a specific entry
     * @param column the column index
     * @param row the row index
     * @param obj new object
     */
    public void set(int column, int row, E obj){
        ExceptionThrower.ifTrue(column >= this.column, new Exception("Entry is out of bound"));
        ExceptionThrower.ifTrue(row >= this.row, new Exception("Entry is out of bound"));
        data[column][row] = obj;
    }

    /**
     * Overrides objects in a range of entries
     * @param column the column index of the starting entry
     * @param row the row index of the starting entry
     * @param objs an array of objects
     */
    public void set(int column, int row, E... objs){
        set(posIndex(column, row), objs);
    }

    /**
     * Overrides objects in a range of entries
     * @param from the begin index
     * @param objs an array of objects
     */
    public void set(long from, E... objs){
        long e = from+objs.length;
        ExceptionThrower.ifTrue(e > size(), new Exception("Number of entries is out of bound (from="+from+",range="+objs.length+")"));
        long i = from;
        int j = 0;
        while(i < e){
            Group<Integer, Integer> pos = posCoords(i);
            data[pos.getA()][pos.getB()] = objs[j];
            i++;
            j++;
        }
    }

    /**
     * Clears all entries
     */
    public void clear(){
        this.data = (E[][]) new Object[column][row];
    }

    /**
     * Clears a specific entry
     * @param column the column index
     * @param row the row index
     */
    public void clear(int column, int row){
        ExceptionThrower.ifTrue(column >= this.column, new Exception("Removing entry is out of bound"));
        ExceptionThrower.ifTrue(row >= this.row, new Exception("Removing entry is out of bound"));
        data[column][row] = null;
    }

    /**
     * Clears a column
     * @param column the column index
     */
    public void clearAllRows(int column){
        ExceptionThrower.ifTrue(column >= this.column, new Exception("Removing entries are out of bound"));
        data[column] = (E[]) new Object[row];
    }

    /**
     * Clears a row
     * @param row the row index
     */
    public void clearAllColumns(int row){
        ExceptionThrower.ifTrue(row >= this.row, new Exception("Removing entries are out of bound"));
        for(int c = 0; c < column; c++){
            data[c][row] = null;
        }
    }

    /**
     * Clears multiple entries
     * @param from the begin index
     * @param length range of entries
     */
    public void clearAll(long from, long length){
        long e = from+length;
        ExceptionThrower.ifTrue(e > size(), new Exception("Removing entries are out of bound"));
        long i = from;
        while(i < e){
            Group<Integer, Integer> pos = posCoords(i);
            data[pos.getA()][pos.getB()] = null;
            i++;
        }
    }

    /**
     * Copies objects in a range of entries to other entries
     * @param src the source index
     * @param des the destination index
     * @param range the range of entries will be copied
     */
    public void copy(long src, long des, int range){
        ExceptionThrower.ifTrue(src+range > size(), new Exception("Entries are out of bound"));
        ExceptionThrower.ifTrue(des+range > size(), new Exception("Entries are out of bound"));
        long i = 0;
        while(i < range){
            Group<Integer, Integer> pos = posCoords(des+i);
            data[pos.getA()][pos.getB()] = get(src+i);
            i++;
        }
    }

    /**
     * Copies objects in a row to other rows
     * @param srcRow the index of the source row
     * @param desRows the indexes of destination rows
     */
    public void copyRow(int srcRow, int... desRows){
        ExceptionThrower.ifTrue(srcRow > row, new Exception("Entries are out of bound"));
        for(int desRow : desRows) {
            int j = 0;
            while(j < column) {
                data[j][desRow] = data[j][srcRow];
                j++;
            }
        }
    }

    /**
     * Copies objects in a range of rows to other rows
     * @param srcRow the index of the source row
     * @param desRow the index of the destination row
     * @param range the range of rows will be copied
     */
    public void copyRows(int srcRow, int desRow, int range){
        ExceptionThrower.ifTrue(srcRow+range > row, new Exception("Entries are out of bound"));
        ExceptionThrower.ifTrue(desRow+range > row, new Exception("Entries are out of bound"));
        int i = 0;
        while(i < range){
            int j = 0;
            while(j < column){
                data[j][desRow+i] = data[j][srcRow+i];
                j++;
            }
            i++;
        }
    }

    /**
     * Copies objects in a column to other columns
     * @param srcColumn the index of the source column
     * @param desColumns the indexes of destination columns
     */
    public void copyColumn(int srcColumn, int... desColumns){
        ExceptionThrower.ifTrue(srcColumn > column, new Exception("Entries are out of bound"));
        for(int desColumn : desColumns){
            data[desColumn] = data[srcColumn];
        }
    }

    /**
     * Copies objects in a range of columns to other columns
     * @param srcColumn the index of the source column
     * @param desColumn the index of the destination column
     * @param range the range of columns will be copied
     */
    public void copyColumns(int srcColumn, int desColumn, int range){
        ExceptionThrower.ifTrue(srcColumn+range > column, new Exception("Entries are out of bound"));
        ExceptionThrower.ifTrue(desColumn+range > column, new Exception("Entries are out of bound"));
        int i = 0;
        while(i < range){
            data[desColumn+i] = data[srcColumn+i];
            i++;
        }
    }

    /**
     * Get the size of the table
     * @return the size
     */
    public long size(){
        return row*column;
    }

    /**
     * Get the number of rows
     * @return the number of rows
     */
    public int rows(){
        return row;
    }

    /**
     * Get the number of columns
     * @return the number of columns
     */
    public int columns(){
        return column;
    }

    /**
     * Get the number of empty entries
     * @return the number of empty entries
     */
    public long emptySize(){
        return remain;
    }

    private Group<Integer, Integer> posCoords(long index) {
        int r = (int) index/column;
        int c = (int) (index-r*column);
        return new Group<>(c, r);
    }

    private long posIndex(int x, int y) {
        return x+y*column;
    }

    /**
     * Get the object from a specific entry
     * @param index the index of the entry
     * @return the object
     */
    public E get(long index){
        ExceptionThrower.ifFalse(index < size(), new Exception("The index is out of bound"));
        Group<Integer, Integer> pos = posCoords(index);
        return data[pos.getA()][pos.getB()];
    }

    /**
     * Get the object from a specific entry
     * @param column the column index
     * @param row the row index
     * @return the object
     */
    public E get(int column, int row){
        ExceptionThrower.ifTrue(column >= this.column, new Exception("Entry is out of bound"));
        ExceptionThrower.ifTrue(row >= this.row, new Exception("Entry is out of bound"));
        return data[column][row];
    }

    /**
     * Convert all entries inside the table into a list.<br>
     * The method will loop through columns and then move to the next row
     * @return list of entries
     */
    public List<E> toList(){
        List<E> list = new ArrayList<>();
        for(int r = 0; r < row; r++){
            for(int c = 0; c < column; c++){
                list.add(data[c][r]);
            }
        }
        return list;
    }

    /**
     * Convert all entries inside the given column into a list.
     * @param column the column index
     * @return list of entries
     */
    public List<E> toListOfRows(int column){
        ExceptionThrower.ifTrue(column >= this.column, new Exception("Entries are out of bound"));
        List<E> list = new ArrayList<>();
        for(int r = 0; r < row; r++){
            list.add(data[column][r]);
        }
        return list;
    }

    /**
     * Convert all entries inside the given row into a list.
     * @param row the row index
     * @return list of entries
     */
    public List<E> toListOfColumns(int row){
        ExceptionThrower.ifTrue(row >= this.row, new Exception("Entries are out of bound"));
        List<E> list = new ArrayList<>();
        for(int c = 0; c < column; c++){
            list.add(data[c][row]);
        }
        return list;
    }

    /**
     * Performs the given action for each entry of the table
     * @param consumer The action to be performed
     */
    public void forEach(Consumer<? super E> consumer){
        for(int c = 0; c < column; c++) {
            for(int r = 0; r < row; r++) {
                consumer.accept(data[c][r]);
            }
        }
    }

    /**
     * Performs the given action for all entries in the given range
     * @param consumer The action to be performed
     * @param from the begin index
     * @param range range of entries
     */
    public void forEach(Consumer<? super E> consumer, long from, int range){
        long e = from+range;
        ExceptionThrower.ifTrue(e > size(), new Exception("Entries are out of bound"));
        long i = from;
        while(i < e){
            consumer.accept(get(i));
            i++;
        }
    }

    /**
     * Performs the given action for all entries in the given row
     * @param consumer The action to be performed
     * @param row the row index
     */
    public void forEachRow(Consumer<? super E> consumer, int row){
        ExceptionThrower.ifTrue(row >= this.row, new Exception("Entries are out of bound"));
        for(int c = 0; c < column; c++){
            consumer.accept(data[c][row]);
        }
    }

    /**
     * Performs the given action for all entries in the given column
     * @param consumer The action to be performed
     * @param column the column index
     */
    public void forEachColumn(Consumer<? super E> consumer, int column){
        ExceptionThrower.ifTrue(column >= this.column, new Exception("Entries are out of bound"));
        for(int r = 0; r < row; r++){
            consumer.accept(data[column][r]);
        }
    }

    /**
     * Clone the object of an entry into its next entries until reaching the range
     * @param index the index of the source entry
     * @param range the range of destination entries
     */
    public void clone(long index, int range){
        E v = get(index);
        int i = 0;
        while (i < range){
            set(index+i+1, v);
            i++;
        }
    }

    /**
     * Delete multiple row at a same time
     * @param rows indexes of rows
     */
    public void deleteRow(int... rows){
        ExceptionThrower.ifTrue(this.row-rows.length < 1, new Exception("Table must have at least one row"));
        int i = 0;
        for(int r : rows) {
            int in = r - i;
            this.row--;
            for(int c = 0; c < column; c++) {
                E[] rowData = (E[]) new Object[this.row];
                System.arraycopy(this.data[c], 0, rowData, 0, in);
                System.arraycopy(this.data[c], in + 1, rowData, in, this.row - in);
                this.data[c] = rowData;
            }
            i++;
        }
    }

    /**
     * Delete multiple column at a same time
     * @param columns indexes of columns
     */
    public void deleteColumn(int... columns){
        ExceptionThrower.ifTrue(this.column-columns.length < 1, new Exception("Table must have at least one column"));
        int i = 0;
        for(int c : columns) {
            int in = c - i;
            this.column--;
            E[][] columnData = (E[][]) new Object[this.column][this.row];
            System.arraycopy(this.data, 0, columnData, 0, in);
            System.arraycopy(this.data, in + 1, columnData, in, this.column - in);
            this.data = columnData;
            i++;
        }
    }

    /**
     * Add multiple rows at a same time.<br>
     * Once the new row is created, all objects will be moved to the bottom by one row
     * @param indexes indexes of rows
     */
    public void addRow(int... indexes){
        int i = 0;
        for(int r : indexes) {
            int in = r + i;
            this.row++;
            for(int c = 0; c < column; c++) {
                E[] rowData = (E[]) new Object[this.row];
                System.arraycopy(this.data[c], 0, rowData, 0, in);
                System.arraycopy(this.data[c], in, rowData, in + 1, this.row - in - 1);
                this.data[c] = rowData;
            }
            i++;
        }
    }

    /**
     * Add multiple columns at a same time.<br>
     * Once the new column is created, all objects will be moved to the right by one column
     * @param indexes indexes of columns
     */
    public void addColumn(int... indexes){
        int i = 0;
        for(int r : indexes) {
            int in = r + i;
            this.column++;
            E[][] columnData = (E[][]) new Object[this.column][this.row];
            System.arraycopy(this.data, 0, columnData, 0, in);
            System.arraycopy(this.data, in, columnData, in + 1, this.column - in - 1);
            this.data = columnData;
            i++;
        }
    }

    /**
     * Expand the table by one row on the left side
     */
    public void addFirstColumn() {
        addColumn(0);
    }

    /**
     * Expand the table by one row on the top
     */
    public void addFirstRow() {
        addRow(0);
    }

    /**
     * Expand the table by one row on the right side
     */
    public void addLastColumn() {
        addColumn(column);
    }

    /**
     * Expand the table by one row at the bottom
     */
    public void addLastRow() {
        addRow(row);
    }

    /**
     * Convert all entries inside the table into an array.<br>
     * The method will loop through columns and then move to the next row
     * @param clazz the class type of elements
     * @return array of entries
     */
    public E[] toArray(Class<E> clazz){
        ArrayBuilder array = new ArrayBuilder(clazz);
        for(int r = 0; r < row; r++){
            for(int c = 0; c < column; c++){
                array.append(data[c][r]);
            }
        }
        return (E[]) array.build();
    }

    /**
     * Convert all entries inside the given column into an array.
     * @param clazz the class type of elements
     * @param column the column index
     * @return array of entries
     */
    public Object[] toArrayOfRows(Class<E> clazz, int column){
        ExceptionThrower.ifTrue(column >= this.column, new Exception("Entries are out of bound"));
        ArrayBuilder array = new ArrayBuilder(clazz);
        for(int r = 0; r < row; r++){
            array.append(data[column][r]);
        }
        return (E[]) array.build();
    }

    /**
     * Convert all entries inside the given row into an array.
     * @param clazz the class type of elements
     * @param row the row index
     * @return array of entries
     */
    public Object[] toArrayOfColumns(Class<E> clazz, int row){
        ExceptionThrower.ifTrue(row >= this.row, new Exception("Entries are out of bound"));
        ArrayBuilder array = new ArrayBuilder(clazz);
        for(int c = 0; c < column; c++){
            array.append(data[c][row]);
        }
        return (E[]) array.build();
    }



    @Override
    public boolean equals(Object o){
        if(o != null && o.getClass() == this.getClass()){
            Table t = (Table) o;
            return new EqualsBuilder()
                    .append(t.column, this.column)
                    .append(t.data, this.data)
                    .append(t.remain, this.remain)
                    .append(t.row, this.row)
                    .append(t.lastEmptySlot, this.lastEmptySlot)
                    .build();
        }
        return false;
    }

    @Override
    public int hashCode(){
        return new HashCodeBuilder(23, 15)
                .append(this.column)
                .append(this.data)
                .append(this.remain)
                .append(this.row)
                .append(this.lastEmptySlot).build();
    }
}
