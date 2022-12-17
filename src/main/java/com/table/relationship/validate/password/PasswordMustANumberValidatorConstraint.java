package com.table.relationship.validate.password;

import com.table.relationship.dto.request.UserRegistrationRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMustANumberValidatorConstraint implements ConstraintValidator
        <PasswordMustANumberAnnotation, String> {


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        return s.matches("[0-9]+");
    }
}
