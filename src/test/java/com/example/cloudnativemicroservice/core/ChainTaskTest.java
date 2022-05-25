package com.example.cloudnativemicroservice.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChainTaskTest {

    private final String start = "Test Start";

    @Test
    void startChain() {
        Assertions.assertEquals(start + "Start of the Chain. \n", ChainTask.startChain(start));
    }

    @Test
    void chainStage2() {
        Assertions.assertEquals(start + "Chain stage 2 \n", ChainTask.chainStage2(start));
    }

    @Test
    void chainStage3() {
        Assertions.assertEquals(start + "Chain stage 3 \n", ChainTask.chainStage3(start));
    }

    @Test
    void chainInfo() {
        Assertions.assertTrue(true);
    }
}