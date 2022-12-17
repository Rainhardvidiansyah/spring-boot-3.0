package com.table.relationship.validate.password;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Constraint(validatedBy = MatchPasswordConstraint.class)
public @interface MatchPasswordAnnotation {

    String message();
    public Class<?>[] groups() default{};
    public Class<? extends Payload>[] payload() default{};
}
