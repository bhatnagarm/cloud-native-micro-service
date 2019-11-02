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
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class})
@ComponentScan(basePackages = { "com.example.cloudnativemicroservice" })
@OpenAPIDefinition(info = @Info(title = "the title",
    version = "0.0", description = "My API",
    license = @License(name = "Apache 2.0", url = "https://opensource.org/licenses/Apache-2.0"),
    contact = @Contact(url = "http://mitul.bhatnagar.techartworks.com", name = "mitul",
        email = "mitul.bhatnagar@gmail.com")))
public class HelloWorldApplication {

  public static void main(String[] args) {
    SpringApplication.run(HelloWorldApplication.class, args);
  }

}
