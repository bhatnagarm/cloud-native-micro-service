package com.example.cloudnativemicroservice.core;

import java.util.concurrent.CompletableFuture;

public class ChainTask<T> {

  static String startChain(String start) {
    return start + "Start of the Chain. \n";
  }

  static String chainStage2(String stage2) {
    return  stage2 + "Chain stage 2 \n";
  }

  static String chainStage3(String stage3) {
    return stage3 + "Chain stage 3 \n";
  }

  static void chainInfo() {
    CompletableFuture<String> pipeline = new CompletableFuture<>();

    pipeline
        .thenApply(ChainTask::startChain)
        .thenApply(ChainTask::chainStage2)
        .thenApply(ChainTask::chainStage3)
        .thenAccept(System.out::println);

    pipeline.complete("Chain execution\n");

  }

  /*static CompletableFuture<T> builder(Class T) {
    return new CompletableFuture<T>();
  }*/

  /*public <U> CompletableFuture<T> stage(
      Function<? super T,? extends U> fn) {

  }*/

/*  public static void main(String[] args) {
    MyTask.chainInfo();

  }*/

}
