package com.table.relationship.validate.password;

import com.table.relationship.dto.request.UserRegistrationRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MatchPasswordConstraint implements ConstraintValidator<MatchPasswordAnnotation, Object> {


    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        var userRegistrationRequestDto = (UserRegistrationRequestDto) o;
        return userRegistrationRequestDto.getConfirmPassword().equals(userRegistrationRequestDto.getPassword());
    }
}
