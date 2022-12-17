package com.table.relationship.dto;

import com.table.relationship.dto.request.UserRegistrationRequestDto;
import com.table.relationship.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelMapperTest {

    private ModelMapper modelMapper = new ModelMapper();


    @Test
    void givenUser_thenMatchWithDtoClass(){
        UserRegistrationRequestDto dto = new UserRegistrationRequestDto();
        dto.setUserName("Rainhard");
        dto.setEmail("email@gmail.com");
        dto.setPassword("pass");
        dto.setConfirmPassword("pass");


        //ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(dto, User.class);

        Assertions.assertEquals(user.getUserName(), dto.getUserName());
    }


    @Test
    void givenRegistrationDto_thenMatchWithEntityUserClass(){
        var user = new User();
        user.setUserName("Hoki");
        user.setPassword("hoki@gmail.com");
        user.setPassword("pass");

        UserRegistrationRequestDto requestDto
                = modelMapper.map(user, UserRegistrationRequestDto.class);
        Assertions.assertEquals(user.getUserName(), requestDto.getUserName());
        Assertions.assertEquals(user.getEmail(), requestDto.getEmail());
        System.out.println(user.getEmail());
        System.out.println(requestDto.getEmail());
    }
}
