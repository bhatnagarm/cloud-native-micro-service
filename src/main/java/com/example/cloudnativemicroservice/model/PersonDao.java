package com.example.cloudnativemicroservice.model;

import org.springframework.util.Assert;

import java.util.function.Consumer;

public class PersonDao {

  private PersonDao() {
    super();
  }
  private PersonDao(PersonDaoBuilder builder) {
    this.name = builder.name;
    this.age = builder.age;
    this.gender = builder.gender;
  }

  public static PersonDaoBuilder builder() {
    return new PersonDaoBuilder();
  }

  private String name;

  private String age;

  private String gender;

  @Override
  public String toString() {
    return "User: " + this.name + ", " + this.age + ", " + this.gender;
  }

  public static class PersonDaoBuilder {

    public String name;
    public String age;
    public String gender;

    public PersonDaoBuilder with(
        Consumer<PersonDaoBuilder> builderFunction) {
      builderFunction.accept(this);
      return this;
    }

    /**
     * Build method returns a copy of the object.
     * @return PersonDao object
     */
    public PersonDao build() {
      PersonDao user =  new PersonDao(this);
      validateUserObject(user);
      return user;
    }

    private void validateUserObject(PersonDao personDao) {
      Assert.notNull(personDao, "PersonDao should not be null.");
    }
  }

}
