package com.example.cloudnativemicroservice;

import com.example.cloudnativemicroservice.model.PersonDao;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Tag(name = "hello_world")
class HelloController {

  @GetMapping("/hello/{name}")
  @Operation(description = "Hello World", responses = {
      @ApiResponse(content = @Content(array = @ArraySchema(schema = @Schema(implementation =
          PersonDao.class))), responseCode = "200") })
  PersonDao greeting(@PathVariable("name") final String name) {
    return PersonDao.builder()
        .with(builder -> {
          builder.name = "Hello " + name;
          builder.age = "30";
          builder.gender = "Male";
        }).build();

  }

}
