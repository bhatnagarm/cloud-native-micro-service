package com.example.cloudnativemicroservice.model;

public class ApiResponse {
  private static final int ERROR = 1;
  private static final int WARNING = 2;
  private static final int INFO = 3;
  private static final int OK = 4;
  private static final int TOO_BUSY = 5;

  private int code;
  private String type;
  private String message;

  private ApiResponse(ApiResponseBuilder apiResponseBuilder) {
    this.code = apiResponseBuilder.code;
    this.message = apiResponseBuilder.message;
    this.type = apiResponseBuilder.type;
  }

  public static ApiResponseBuilder builder() {
    return new ApiResponseBuilder();
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getType() {
    return type;
  }

  public String getMessage() {
    return message;
  }

  public static class ApiResponseBuilder {

    private int code;
    private String type;
    private String message;

    public ApiResponseBuilder code(int code) {
      this.code = code;
      return this;
    }

    public ApiResponseBuilder type(String type) {
      this.type = type;
      return this;
    }

    public ApiResponseBuilder message(String message) {
      this.message = message;
      return this;
    }

    //Return the finally consrcuted object
    public ApiResponse build() {
      ApiResponse apiResponse =  new ApiResponse(this);
      validateUserObject(apiResponse);
      return apiResponse;
    }

    private void validateUserObject(ApiResponse apiResponse) {
      //Do some basic validations to check
      //if user object does not break any assumption of system
    }
  }

}
