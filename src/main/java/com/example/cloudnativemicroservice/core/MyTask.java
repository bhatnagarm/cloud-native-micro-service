package com.example.cloudnativemicroservice.core;

import java.util.concurrent.CompletableFuture;

public class MyTask<T> {

  static String startChain(final String start) {
    return start + "Start of the Chain. \n";
  }

  static String chainStage2(final String stage2) {
    return  stage2 + "Chain stage 2 \n";
  }

  static String chainStage3(final String stage3) {
    return stage3 + "Chain stage 3 \n";
  }

  static void chainInfo() {
    CompletableFuture<String> pipeline = new CompletableFuture<>();

    pipeline
        .thenApply(MyTask::startChain)
        .thenApply(MyTask::chainStage2)
        .thenApply(MyTask::chainStage3)
        .thenAccept(System.out::println);

    pipeline.complete("Chain execution\n");

  }

/*
  static CompletableFuture<T> builder(Class T) {
    return new CompletableFuture<T>();
  }

  public <U> CompletableFuture<T> stage(
      Function<? super T,? extends U> fn) {
  }
*/

  public static void main(String[] args) {
    MyTask.chainInfo();

  }

}
