package org.anhcraft.spaciouslib.serialization;

import org.anhcraft.spaciouslib.utils.Table;

/**
 * A mapping of data names
 */
public class DataMapping {
    private Table<String> map;

    public DataMapping() {
        this.map = new Table<>(2, 0);
    }

    /**
     * Insert a row of mapping
     * @param oldName old name
     * @param newName new name
     * @return this object
     */
    public DataMapping insert(String oldName, String newName){
        map.addLastRow();
        map.set(0, map.rows()-1, oldName, newName);
        return this;
    }

    public String get(String oldName){
        for(int i = 0; i < map.rows(); i++){
            if(map.get(0, i).equals(oldName)){
                return map.get(1, i);
            }
        }
        return oldName;
    }
}
