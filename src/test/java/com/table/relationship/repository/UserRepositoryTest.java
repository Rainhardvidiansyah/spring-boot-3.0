package com.table.relationship.repository;

import com.table.relationship.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void entityNotNullTest(){
        Assertions.assertThat(entityManager).isNotNull();

    }

    @Test
    void givenListOfUser_ThenReturnEmpty(){
        var user = userRepository.findAll();
        Assertions.assertThat(user).isEmpty();
    }

    @Test
    void saveThenFindById(){
        var user = new User();

        entityManager.persist(user);

        Optional<User> findId = userRepository.findById(1L);

        Assertions.assertThat(user.getUserID()).isLessThan(2L);
        Assertions.assertThat(user.getUserName()).isNull();
    }



}