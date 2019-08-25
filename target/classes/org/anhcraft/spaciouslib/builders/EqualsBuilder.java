package org.anhcraft.spaciouslib.builders;

import org.anhcraft.spaciouslib.utils.CommonUtils;

public class EqualsBuilder {
    private boolean equal = true;

    public EqualsBuilder append(Object a, Object b) {
        if(!equal){
            return this;
        }
        if(a == null && b != null || a != null && b == null){
            equal = false;
            return this;
        }
        equal = CommonUtils.compare(a, b);
        return this;
    }

    public EqualsBuilder append(int a, int b) {
        if(!equal){
            return this;
        }
        equal = (a == b);
        return this;
    }

    public EqualsBuilder append(double a, double b) {
        if(!equal){
            return this;
        }
        equal = (a == b);
        return this;
    }

    public EqualsBuilder append(float a, float b) {
        if(!equal){
            return this;
        }
        equal = (a == b);
        return this;
    }

    public EqualsBuilder append(byte a, byte b) {
        if(!equal){
            return this;
        }
        equal = (a == b);
        return this;
    }

    public EqualsBuilder append(short a, short b) {
        if(!equal){
            return this;
        }
        equal = (a == b);
        return this;
    }

    public EqualsBuilder append(boolean a, boolean b) {
        if(!equal){
            return this;
        }
        equal = (a == b);
        return this;
    }

    public EqualsBuilder append(long a, long b) {
        if(!equal){
            return this;
        }
        equal = (a == b);
        return this;
    }

    public EqualsBuilder append(int[] a, int[] b) {
        if(!equal){
            return this;
        }
        if(a == null && b != null || a != null && b == null){
            equal = false;
            return this;
        }
        if(a.length != b.length) {
            equal = false;
            return this;
        }
        for(int oa : a){
            for(int ob : b){
                if(oa != ob){
                    equal = false;
                    break;
                }
            }
        }
        return this;
    }

    public EqualsBuilder append(double[] a, double[] b) {
        if(!equal){
            return this;
        }
        if(a == null && b != null || a != null && b == null){
            equal = false;
            return this;
        }
        if(a.length != b.length) {
            equal = false;
            return this;
        }
        for(double oa : a){
            for(double ob : b){
                if(oa != ob){
                    equal = false;
                    break;
                }
            }
        }
        return this;
    }

    public EqualsBuilder append(float[] a, float[] b) {
        if(!equal){
            return this;
        }
        if(a == null && b != null || a != null && b == null){
            equal = false;
            return this;
        }
        if(a.length != b.length) {
            equal = false;
            return this;
        }
        for(float oa : a){
            for(float ob : b){
                if(oa != ob){
                    equal = false;
                    break;
                }
            }
        }
        return this;
    }

    public EqualsBuilder append(byte[] a, byte[] b) {
        if(!equal){
            return this;
        }
        if(a == null && b != null || a != null && b == null){
            equal = false;
            return this;
        }
        if(a.length != b.length) {
            equal = false;
            return this;
        }
        for(byte oa : a){
            for(byte ob : b){
                if(oa != ob){
                    equal = false;
                    break;
                }
            }
        }
        return this;
    }

    public EqualsBuilder append(short[] a, short[] b) {
        if(!equal){
            return this;
        }
        if(a == null && b != null || a != null && b == null){
            equal = false;
            return this;
        }
        if(a.length != b.length) {
            equal = false;
            return this;
        }
        for(short oa : a){
            for(short ob : b){
                if(oa != ob){
                    equal = false;
                    break;
                }
            }
        }
        return this;
    }

    public EqualsBuilder append(boolean[] a, boolean[] b) {
        if(!equal){
            return this;
        }
        if(a == null && b != null || a != null && b == null){
            equal = false;
            return this;
        }
        if(a.length != b.length) {
            equal = false;
            return this;
        }
        for(boolean oa : a){
            for(boolean ob : b){
                if(oa != ob){
                    equal = false;
                    break;
                }
            }
        }
        return this;
    }

    public EqualsBuilder append(long[] a, long[] b) {
        if(!equal){
            return this;
        }
        if(a == null && b != null || a != null && b == null){
            equal = false;
            return this;
        }
        if(a.length != b.length) {
            equal = false;
            return this;
        }
        for(long oa : a){
            for(long ob : b){
                if(oa != ob){
                    equal = false;
                    break;
                }
            }
        }
        return this;
    }

    public boolean build() {
        return equal;
    }
}
