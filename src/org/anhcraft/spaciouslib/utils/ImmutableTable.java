package org.anhcraft.spaciouslib.utils;

import org.anhcraft.spaciouslib.annotations.Immutable;

/**
 * Represent an immutable table.
 * @param <E> the type of elements in this table
 */
@Immutable
public class ImmutableTable<E> extends Table<E>{
    /**
     * Creates an immutable table
     * @param column number of columns
     * @param row number of rows    
    */
    public ImmutableTable(int column, int row){
        super(column, row);
    }

    /**
     * Clones an existing table
     * @param table existing table    
    */
    public ImmutableTable(Table<E> table){
        super(table);
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void insert(E... objs){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void set(long index, E obj){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void set(int column, int row, E obj){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void set(int column, int row, E... objs){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void set(long from, E... objs){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation    
    */
    @Override
    @Deprecated
    public void clear(){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void clear(int column, int row){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void clearAllRows(int column){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void clearAllColumns(int row){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void clearAll(long from, long length){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void copy(long src, long des, int range){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void copyRow(int srcRow, int... desRows){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void copyRows(int srcRow, int desRow, int range){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void copyColumn(int srcColumn, int... desColumns){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void copyColumns(int srcColumn, int desColumn, int range){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void clone(long index, int range){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void deleteRow(int... rows){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void deleteColumn(int... columns){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void addRow(int... indexes){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
    */
    @Override
    @Deprecated
    public void addColumn(int... indexes){
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation    
    */
    @Override
    @Deprecated
    public void addFirstColumn() {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation    
    */
    @Override
    @Deprecated
    public void addFirstRow() {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation    
    */
    @Override
    @Deprecated
    public void addLastColumn() {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation    
    */
    @Override
    @Deprecated
    public void addLastRow() {
        throw new UnsupportedOperationException();
    }
}
