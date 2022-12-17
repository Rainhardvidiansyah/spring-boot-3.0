package com.table.relationship.service;

import com.table.relationship.entity.User;
import com.table.relationship.repository.UserRepository;
import com.table.relationship.utils.RandomStringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;

    public User register(User user){
        user.setAccountNumber(RandomStringUtils.generateRandomString());
        log.info("New user data: {}", user);
        return userRepository.save(user);
    }
}
