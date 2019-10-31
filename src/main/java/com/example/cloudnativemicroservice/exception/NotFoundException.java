package com.example.cloudnativemicroservice.exception;

public class NotFoundException extends ApiException {

  private int code;

  public NotFoundException(final int code, final String msg) {
    super(404, msg);
    this.code = code;
  }
}
