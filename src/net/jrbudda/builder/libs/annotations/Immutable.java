package net.jrbudda.builder.libs.annotations;

import java.lang.annotation.*;

/**
 * This annotation is uses for marking immutable objects
 */
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Immutable {
}