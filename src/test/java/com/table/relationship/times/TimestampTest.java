package com.table.relationship.times;


import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;

public class TimestampTest {

    @Test
    void timestampTest(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("Timestamp without method in it: " + timestamp);
    }

    @Test
    void convertTimeStampToInstant(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("Timestamp using getTime() method: " + timestamp.getTime());
        Instant instant = timestamp.toInstant();
        System.out.println(instant);

        Timestamp timestamp1 = Timestamp.from(instant);
        System.out.println("From instant: " + timestamp1);
    }


}
