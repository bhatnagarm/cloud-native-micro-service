package com.example.cloudnativemicroservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class},
        scanBasePackages = { "com.example.cloudnativemicroservice" })
@OpenAPIDefinition(info = @Info(title = "Cloud Native MicroService",
    version = "0.0", description = "Cloud Native MicroService with pipeline architecture",
    license = @License(name = "Apache 2.0", url = "https://opensource.org/licenses/Apache-2.0"),
    contact = @Contact(url = "http://mitul.bhatnagar.techartworks.com", name = "Mitul",
        email = "mitul.bhatnagar@gmail.com")))
public class CloudNativeApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudNativeApplication.class, args);
  }

}
