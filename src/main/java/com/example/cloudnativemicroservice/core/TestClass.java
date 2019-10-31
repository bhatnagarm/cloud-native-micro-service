package com.example.cloudnativemicroservice.core;

@Deprecated
public class TestClass {
  public static void main(String[] args) {
    TestClass.useCompletableFuture();

  }

  public static void useCompletableFuture() {
    long start = System.nanoTime();
    MyTask.chainInfo();
    long duration = (System.nanoTime() - start) / 1_000_000;
    //System.out.printf("Processed %d tasks in %d millis\n", tasks.size(), duration);
  }
}
