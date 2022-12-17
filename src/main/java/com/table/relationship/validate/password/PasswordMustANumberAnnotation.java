package com.table.relationship.validate.password;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PasswordMustANumberValidatorConstraint.class)
public @interface PasswordMustANumberAnnotation {
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
