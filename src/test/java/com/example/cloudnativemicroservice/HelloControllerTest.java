package com.example.cloudnativemicroservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HelloControllerTest {

  private HelloController helloController;

  @Before
  public void setUp() {
    helloController = new HelloController();
  }

  @Test
  public void helloController_default_value() {
    Assert.assertNotNull("Not null object", helloController.greeting("World"));
  }

}
