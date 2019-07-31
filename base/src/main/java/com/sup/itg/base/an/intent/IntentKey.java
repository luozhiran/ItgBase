package com.sup.itg.base.an.intent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IntentKey {
    int defaultInt() default 0;

    double defaultDouble() default 0;

    float defaultFloat() default 0;

    String value();

}
