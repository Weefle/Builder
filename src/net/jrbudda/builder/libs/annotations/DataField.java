package net.jrbudda.builder.libs.annotations;

import java.lang.annotation.*;

/**
 * DataField is the annotation for serializable declared fields in objects.
 */
@Inherited
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataField {
    /**
     * This element is used to determine old data field names
     * @return array of old names
     */
    String[] oldNames() default "";
}
