package com.table.relationship.dto;

import com.table.relationship.dto.request.AddressDto;
import com.table.relationship.dto.request.PersonDto;
import com.table.relationship.dto.request.UserRegistrationRequestDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class AllDtoClassesTestValidation {

    private ValidatorFactory validatorFactory;
    private Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    void testAddress(){
        AddressDto addressDto = new AddressDto();
        addressDto.setStreetName("Bandung van Java street");
        addressDto.setDistrict("West Java");

        Set<ConstraintViolation<AddressDto>> constraintViolations = validator.validate(addressDto);
        for (ConstraintViolation<AddressDto> constraintViolation: constraintViolations){
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getPropertyPath());
            System.out.println(constraintViolation.getInvalidValue());
            System.out.println("___________________");
        }
    }

    @Test
    void testPerson(){
        var personDto = new PersonDto();
        personDto.setPersonID(UUID.randomUUID().toString());
        personDto.setEmail("email@gmail.com");
        personDto.setName("Name is name");

        var address = new AddressDto();
        address.setDistrict("West Java");
        address.setStreetName("Bandung Street");
        personDto.setAddresses(List.of(address));

        Set<ConstraintViolation<PersonDto>> constraintViolations = validator.validate(personDto);
        for (ConstraintViolation<PersonDto> constraintViolation: constraintViolations){
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getPropertyPath());
            System.out.println(constraintViolation.getInvalidValue());
            System.out.println(constraintViolation.getRootBeanClass());
            System.out.println("___________________");
        }

        Assertions.assertNotNull(personDto.getPersonID());
        Assertions.assertNotNull(personDto.getName());
        Assertions.assertNotNull(personDto.getAddresses());
    }

    @Test
    void testUserRegistrationRequestDTO(){
        var user = new UserRegistrationRequestDto();
        user.setUserName("Rainhard");
        user.setEmail("email@gmail.com");
        user.setPassword("12345678");
        user.setConfirmPassword("12345678");


        Set<ConstraintViolation<UserRegistrationRequestDto>> constraintViolations = validator.validate(user);
        for (ConstraintViolation<UserRegistrationRequestDto> constraintViolation: constraintViolations){
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getPropertyPath());
            System.out.println(constraintViolation.getInvalidValue());
            System.out.println(constraintViolation.getRootBeanClass());
            System.out.println("___________________");
        }

        Assertions.assertNotNull(constraintViolations);
    }
}
