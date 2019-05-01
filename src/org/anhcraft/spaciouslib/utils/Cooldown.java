package org.anhcraft.spaciouslib.utils;

import org.anhcraft.spaciouslib.builders.EqualsBuilder;
import org.anhcraft.spaciouslib.builders.HashCodeBuilder;
import org.anhcraft.spaciouslib.annotations.DataField;
import org.anhcraft.spaciouslib.annotations.Serializable;

/**
 * Represents a cooldown timer
 */
@Serializable
public class Cooldown {
    @DataField(oldNames = {"current"})
    private long lastTime;

    /**
     * Create a new cooldown timer.<br>
     * The last time of this timer is understood as the current time
     */
    public Cooldown(){
        this.lastTime = System.currentTimeMillis();
    }

    /**
     * Create a new cooldown timer
     * @param lastTime the last time
     */
    public Cooldown(long lastTime){
        this.lastTime = lastTime;
    }

    /**
     * Reset the cooldown timer.<br>
     * The last time of this timer is reset to the current time
     * @return this object
     */
    public Cooldown reset(){
        lastTime = System.currentTimeMillis();
        return this;
    }

    /**
     * Get the elapsed time
     * @return time duration in seconds
     */
    public double elapsedTime(){
        return (System.currentTimeMillis()-lastTime)/1000d;
    }

    /**
     * Compares the present with the last time in order to determine whether the elapsed time overcomes the given time duration
     * @param seconds time duration in seconds
     * @return true if yes
     */
    public boolean isTimeout(double seconds){
        return elapsedTime() > seconds;
    }

    /**
     * Get the time left until the elapsed time equals with the given time duration
     * @param seconds time duration in seconds
     * @return true if yes
     */
    public double timeLeft(double seconds){
        return seconds - elapsedTime();
    }

    @Override
    public boolean equals(Object o){
        if(o != null && o.getClass() == this.getClass()){
            Cooldown c = (Cooldown) o;
            return new EqualsBuilder()
                    .append(c.lastTime, this.lastTime)
                    .build();
        }
        return false;
    }

    @Override
    public int hashCode(){
        return new HashCodeBuilder(15, 43)
                .append(this.lastTime).build();
    }
}
