package com.table.relationship.utils;

public class RandomStringUtils {

    public static String generateRandomString(){
        String randomNumber = "0123456789";
        int length = 8;
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < 8; i++) {
            int index = (int)(randomNumber.length() * Math.random());
            stringBuilder.append(randomNumber.charAt(index));
        }
        return stringBuilder.toString();
    }
}
