package com.example.cloudnativemicroservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HelloRestControllerTest {

  private HelloRestController helloController;

  @Before
  public void setUp() {
    helloController = new HelloRestController();
  }

  @Test
  public void helloController_default_value() {
    Assert.assertNotNull("Not null object", helloController.greeting("World"));
  }

}
