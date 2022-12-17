package com.table.relationship.thread;

import org.junit.jupiter.api.Test;

public class ThreadTest {

    @Test
    void testThread(){
        Runnable runnable = () -> {
            Thread thread = new Thread();
        };

        var t = new Thread(runnable);
    }
}
