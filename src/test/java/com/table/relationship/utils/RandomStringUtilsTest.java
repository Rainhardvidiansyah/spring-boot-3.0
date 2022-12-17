package com.table.relationship.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomStringUtilsTest {

    @Test
    void generateRandomStringTest(){
        String random = RandomStringUtils.generateRandomString();
        Assertions.assertNotNull(random);
        System.out.println(random);
    }
}
