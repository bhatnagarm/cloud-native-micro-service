package com.example.cloudnativemicroservice.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyTaskTest {

  private final String start = "Test Start";

  @DisplayName("Test Start Chain")
  @Test
  void startChain() {
    Assertions.assertEquals(start + "Start of the Chain. \n", MyTask.startChain(start));
  }

  @Test
  void chainStage2() {
    Assertions.assertEquals(start + "Chain stage 2 \n", MyTask.chainStage2(start));
  }

  @Test
  void chainStage3() {
    Assertions.assertEquals(start + "Chain stage 3 \n", MyTask.chainStage3(start));
  }

  @Test
  void chainInfo() {
    Assertions.assertTrue(true);
  }

}