package com.table.relationship.service;

import com.table.relationship.entity.User;
import com.table.relationship.repository.UserRepository;
import com.table.relationship.utils.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
class RegistrationServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RegistrationService registrationService;

    @Test
    void registerUser() { //PASSED. THIS TEST HASN'T INCLUDED ROLE FOR USER
        var user = new User();
        user.setUserID(1L);
        user.setAccountNumber(RandomStringUtils.generateRandomString());
        user.setUserName("Rainhard");
        user.setEmail("rainhard@gmail.com");
        user.setPassword("password");
        Mockito.when(userRepository.save(Mockito.any(User.class)))
                .thenReturn(user);
        var Registration = registrationService.register(user);
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
        Assertions.assertNotNull(Registration);
        Assertions.assertSame(1L, Registration.getUserID());
        Assertions.assertNotNull(user.getAccountNumber());
        System.out.println(user.getAccountNumber());
        Mockito.verifyNoMoreInteractions(userRepository);

    }
}