package org.anhcraft.spaciouslib.builders;

import org.anhcraft.spaciouslib.utils.ExceptionThrower;
import org.anhcraft.spaciouslib.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class SQLInsertOrUpdateBuilder {
    private HashMap<String, String> data = new HashMap<>();
    private String table;

    public SQLInsertOrUpdateBuilder(String table){
        ExceptionThrower.ifNull(table, new Exception("Table name must not null"));
        this.table = table;
    }

    public SQLInsertOrUpdateBuilder add(String name, String value){
        data.put(name, value == null ? "null" : value);
        return this;
    }

    public SQLInsertOrUpdateBuilder add(String name, double value){
        data.put(name, Double.toString(value));
        return this;
    }

    public SQLInsertOrUpdateBuilder add(String name, float value){
        data.put(name, Float.toString(value));
        return this;
    }

    public SQLInsertOrUpdateBuilder add(String name, short value){
        data.put(name, Short.toString(value));
        return this;
    }

    public SQLInsertOrUpdateBuilder add(String name, long value){
        data.put(name, Long.toString(value));
        return this;
    }

    public SQLInsertOrUpdateBuilder add(String name, int value){
        data.put(name, Integer.toString(value));
        return this;
    }

    public SQLInsertOrUpdateBuilder add(String name, boolean value){
        data.put(name, Boolean.toString(value));
        return this;
    }

    public SQLInsertOrUpdateBuilder add(String name, Enum<?> value) {
        data.put(name, value == null ? "null" : value.toString());
        return this;
    }

    public String build(){
        StringBuilder x = new StringBuilder("INSERT INTO `" + table + "`(" + String.join(",", data.keySet()) + ") VALUES(");
        int i = 0;
        for(String n : data.values()){
            x.append("\"").append(StringUtils.escape(n)).append("\"");
            if(i < data.size() - 1){
                x.append(",");
            }
            i++;
        }
        x.append(") ON DUPLICATE KEY UPDATE ");
        i = 0;
        for(Map.Entry<String, String> entry : data.entrySet()){
            x.append(entry.getKey()).append("=\"").append(StringUtils.escape(entry.getValue())).append("\"");
            if(i < data.size() - 1){
                x.append(", ");
            }
            i++;
        }
        return x.toString();
    }
}
