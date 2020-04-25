package net.jrbudda.builder.libs.utils;

import net.jrbudda.builder.libs.annotations.DataField;
import net.jrbudda.builder.libs.annotations.Serializable;
import net.jrbudda.builder.libs.builders.EqualsBuilder;
import net.jrbudda.builder.libs.builders.HashCodeBuilder;

/**
 * A group is a group of two objects (A and B).<br>
 * With a group, it is possible to store a group in another group.
 * @param <A> the type of first object
 * @param <B> the type of second object
 */
@Serializable
public class Group<A, B> {
    @DataField
    private A a;
    @DataField
    private B b;

    public Group(){}

    /**
     * Creates a new Group instance
     * @param a the object A
     * @param b the object b
     */
    public Group(A a, B b){
        this.a = a;
        this.b = b;
    }

    /**
     * Gets the object A
     * @return the object A
     */
    public A getA(){
        return this.a;
    }

    /**
     * Gets the object B
     * @return the object B
     */
    public B getB(){
        return this.b;
    }

    /**
     * Sets the given value for the object A.<br>
     * It must have the same data type with the old value
     * @param a the new value for object A
     * @return this object
     */
    public Group<A, B> setA(A a){
        this.a = a;
        return this;
    }

    /**
     * Sets the given value for the object B.<br>
     * It must have the same data type with the old value
     * @param b the new value for object B
     * @return this object
     */
    public Group<A, B> setB(B b){
        this.b = b;
        return this;
    }

    @Override
    public boolean equals(Object o){
        if(o != null && o.getClass() == this.getClass()){
            Group<?, ?> g = (Group<?, ?>) o;
            return new EqualsBuilder()
                    .append(g.a, this.a)
                    .append(g.b, this.b)
                    .build();
        }
        return false;
    }

    @Override
    public int hashCode(){
        return new HashCodeBuilder(27, 45)
                .append(this.a).append(this.b).build();
    }
}