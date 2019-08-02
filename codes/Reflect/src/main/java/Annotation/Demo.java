package Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//这个代表一个@Demo的注解
@Retention(RetentionPolicy.RUNTIME)
public @interface Demo {

}
