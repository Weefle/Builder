package org.anhcraft.spaciouslib.utils;

import java.util.Comparator;
import java.util.TreeMap;

public enum  TimeUnit {
    MILLISECOND(1),
    MINECRAFT_TICK(50),
    SECOND(1000),
    MINUTE(SECOND.ms * 60L),
    HOUR(MINUTE.ms * 60),
    DAY(HOUR.ms * 24),
    WEEK(DAY.ms * 7),
    MONTH_28(DAY.ms * 28),
    MONTH_29(DAY.ms * 29),
    MONTH_30(DAY.ms * 30),
    MONTH_31(DAY.ms * 31),
    YEAR(DAY.ms * 365),
    LEAP_YEAR(DAY.ms * 366),
    DECADE(YEAR.ms * 8 + LEAP_YEAR.ms * 2),
    CENTURY(DECADE.ms * 10),
    MILLENNIUM(CENTURY.ms * 10);

    private long ms;

    TimeUnit(long ms) {
        this.ms = ms;
    }

    /**
     * Returns the number of milliseconds that this unit equals to.
     * @return milliseconds
     */
    public long getMillis(){
        return this.ms;
    }

    /**
     * Converts the given duration to a new time unit.
     * @param duration duration
     * @param to new unit
     * @return converted duration
     */
    public long convert(long duration, TimeUnit to){
        return duration*ms/to.getMillis();
    }

    /**
     * Converts the given duration to milliseconds directly.
     * @param duration duration
     * @return converted duration
     */
    public long toMillis(long duration){
        return duration*ms;
    }

    /**
     * Format the given time duration in the given time unit.
     * @param unit the time unit
     * @param duration the duration (in milliseconds)
     * @param formattedUnits formatted units
     * @return a map contains pairs of a formatted unit and its time duration
     */
    public static TreeMap<TimeUnit, Long> format(TimeUnit unit, long duration, TimeUnit[] formattedUnits){
        ExceptionThrower.ifTrue(duration < 0, new Exception("Duration must be a positive integer"));
        // sort the formatted units array in descending order

        TreeMap<TimeUnit, Long> map = new TreeMap<>(Comparator.comparingDouble(
                TimeUnit::getMillis).reversed());
        for(TimeUnit u : formattedUnits){
            if(duration <= 0){
                map.put(u, 0L);
            } else {
                // convert the remaining duration from the original unit to the formatted unit
                long x = (long) unit.convert(duration, u);
                map.put(u, x);
                // convert back the duration from the the formatted unit to the original unit
                // then update the remaining duration
                duration -= u.convert(x, unit);
            }
        }
        return map;
    }
}
