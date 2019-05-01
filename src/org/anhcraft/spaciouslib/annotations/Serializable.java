package org.anhcraft.spaciouslib.annotations;

import java.lang.annotation.*;

/**
 * This is the annotation for defining serializable classes.
 */
@Inherited
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Serializable {

}
