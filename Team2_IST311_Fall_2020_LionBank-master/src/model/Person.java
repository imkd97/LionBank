package model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import util.StringUtil;

import java.security.InvalidParameterException;
import java.time.LocalDate;

public class Person implements IPerson
{
  Identifier id;
  String firstName;
  String lastName;
  String middleName;
  public Person() {
    this.id = new Identifier();
  }

  private void validateName(String desc, String str) {
    if (StringUtil.isNullOrWhitespace(str)) {
      throw new InvalidParameterException(desc + " name must have a non-blank value");
    }
  }

  public Person(String firstName, String middleName, String lastName) {
    // TODO Person.java 01 - validate first name with validateName method
    // Aaron Coccagna (azc5793@psu.edu)
    this.validateName("First", firstName);

    // TODO Person.java 02 - validate last name with validateName method
    // Aaron Coccagna (azc5793@psu.edu)
    this.validateName("Last", lastName);

    // TODO Person.java 03 - Set fields from the given arguments
    // Aaron Coccagna (azc5793@psu.edu)
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  public Person(String firstName, String lastName) {
    // TODO Person.java 04 - Call the other constructor appropriately
    // Aaron Coccagna (azc5793@psu.edu)
    this(firstName, " ", lastName);
    // https://stackoverflow.com/a/285184/673393

  }

  @Override
  public String fullName() {
    // TODO Person.java 05 - implement fullName()
    // Aaron Coccagna (azc5793@psu.edu)
    if (middleName != " ") {
          middleName = " " +middleName.charAt(0) + "." + " ";
      }
    return firstName  +  middleName  + lastName;

  }
}
