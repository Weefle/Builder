package org.anhcraft.spaciouslib.builders;


import org.anhcraft.spaciouslib.utils.ExceptionThrower;

public class HashCodeBuilder {
    private int total;
    private int multiplier;

    public HashCodeBuilder(int initialOddNumber, int multiplierOddNumber) {
        ExceptionThrower.ifTrue(initialOddNumber % 2 == 0,
                new Exception("The initial number must be an odd"));
        ExceptionThrower.ifTrue(multiplierOddNumber % 2 == 0,
                new Exception("The multiplier number must be an odd"));
        total = initialOddNumber;
        multiplier = multiplierOddNumber;
    }

    public HashCodeBuilder append(Object object) {
        total += total * multiplier + (object == null ? 0 : object.hashCode());
        return this;
    }

    public HashCodeBuilder append(long value) {
        total += total * multiplier + ((int) (value ^ (value >> 32)));
        return this;
    }

    public HashCodeBuilder append(int value) {
        total += total * multiplier + value;
        return this;
    }

    public HashCodeBuilder append(float value) {
        total += total * multiplier + Float.floatToIntBits(value);
        return this;
    }

    public HashCodeBuilder append(double value) {
        return append(Double.doubleToLongBits(value));
    }

    public HashCodeBuilder append(short value) {
        total += total * multiplier + value;
        return this;
    }

    public HashCodeBuilder append(byte value) {
        total += total * multiplier + value;
        return this;
    }

    public HashCodeBuilder append(boolean value) {
        total += total * multiplier + (value ? 1 : 0);
        return this;
    }

    public HashCodeBuilder append(Object[] object) {
        if(object != null){
            for(Object obj : object){
                append(obj);
            }
        }
        return this;
    }

    public HashCodeBuilder append(long[] value) {
        if(value != null) {
            for(long v : value) {
                append(v);
            }
        }
        return this;
    }

    public HashCodeBuilder append(int[] value) {
        if(value != null) {
            for(int v : value) {
                append(v);
            }
        }
        return this;
    }

    public HashCodeBuilder append(float[] value) {
        if(value != null) {
            for(float v : value) {
                append(v);
            }
        }
        return this;
    }

    public HashCodeBuilder append(double[] value) {
        if(value != null) {
            for(double v : value){
                append(v);
            }
        }
        return this;
    }

    public HashCodeBuilder append(short[] value) {
        if(value != null) {
            for(short v : value){
                append(v);
            }
        }
        return this;
    }

    public HashCodeBuilder append(byte[] value) {
        if(value != null) {
            for(byte v : value){
                append(v);
            }
        }
        return this;
    }

    public HashCodeBuilder append(boolean[] value) {
        if(value != null) {
            for(boolean v : value) {
                append(v);
            }
        }
        return this;
    }

    @Override
    public int hashCode(){
        return total;
    }

    public int build(){
        return total;
    }
}
