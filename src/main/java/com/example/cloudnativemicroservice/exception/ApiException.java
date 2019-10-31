package com.example.cloudnativemicroservice.exception;


class ApiException extends Exception {

  private int code;

  public ApiException(final int code, final String msg) {
    super(msg);
    this.code = code;
  }
}
