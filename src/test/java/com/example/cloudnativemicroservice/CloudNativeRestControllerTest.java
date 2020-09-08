package com.example.cloudnativemicroservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CloudNativeRestControllerTest {

  private CloudNativeRestController helloController;

  @Before
  public void setUp() {
    helloController = new CloudNativeRestController();
  }

  @Test
  public void helloController_default_value() {
    Assert.assertNotNull("Not null object", helloController.greeting("World"));
  }

}
