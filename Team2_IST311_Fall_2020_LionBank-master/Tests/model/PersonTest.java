/* DON'T TOUCH! */package model;
/* DON'T TOUCH! */
/* DON'T TOUCH! */import org.junit.After;
/* DON'T TOUCH! */import org.junit.Before;
/* DON'T TOUCH! */import org.junit.Test;
/* DON'T TOUCH! */import util.Obj;
/* DON'T TOUCH! */
/* DON'T TOUCH! */import java.security.InvalidParameterException;
/* DON'T TOUCH! */
/* DON'T TOUCH! */import static org.junit.Assert.*;
/* DON'T TOUCH! */
/* DON'T TOUCH! */public class PersonTest
/* DON'T TOUCH! */{
/* DON'T TOUCH! */  private Person personFirstMiddleLast;
/* DON'T TOUCH! */  private Person personFirstLast;
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Before
/* DON'T TOUCH! */  public void setUp() throws Exception {
/* DON'T TOUCH! */    personFirstMiddleLast = new Person("James", "Arthur", "Gossling");
/* DON'T TOUCH! */    personFirstLast = new Person("Bill", "Gates");
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @After
/* DON'T TOUCH! */  public void tearDown() throws Exception {
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void ctor__Pass_various_invalids__Throws_exception() {
/* DON'T TOUCH! */    String tests[][] = {
/* DON'T TOUCH! */        {null, null},
/* DON'T TOUCH! */        {"", ""},
/* DON'T TOUCH! */        {"  ", ""},
/* DON'T TOUCH! */        {"", " "},
/* DON'T TOUCH! */        {" ", " "},
/* DON'T TOUCH! */        {null, "last"},
/* DON'T TOUCH! */        {"first", null},
/* DON'T TOUCH! */        {"", null},
/* DON'T TOUCH! */        {"", "last"},
/* DON'T TOUCH! */        {"first", ""},
/* DON'T TOUCH! */        {"  ", null},
/* DON'T TOUCH! */        {"  ", "last"},
/* DON'T TOUCH! */        {"first", "  "}
/* DON'T TOUCH! */    };
/* DON'T TOUCH! */
/* DON'T TOUCH! */    Person p = null;
/* DON'T TOUCH! */    for (String[] test : tests) {
/* DON'T TOUCH! */      String first = test[0];
/* DON'T TOUCH! */      String last = test[1];
/* DON'T TOUCH! */      try {
/* DON'T TOUCH! */        p = new Person(first, last);
/* DON'T TOUCH! */      } catch (InvalidParameterException e) {
/* DON'T TOUCH! */        // Do nothing, because we expected an exception
/* DON'T TOUCH! */      }
/* DON'T TOUCH! */      if (p != null) {
/* DON'T TOUCH! */        String fmt = "'%s %s' should have thrown an exception";
/* DON'T TOUCH! */        String msg = String.format(fmt, Obj.coalesce(first, "null"), Obj.coalesce(last, "null"));
/* DON'T TOUCH! */        fail(msg);
/* DON'T TOUCH! */      }
/* DON'T TOUCH! */    }
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void fullName__First_middle_last__Has_correct_full_name() {
/* DON'T TOUCH! */    String expected = "James A. Gossling";
/* DON'T TOUCH! */    assertEquals(expected, personFirstMiddleLast.fullName());
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void fullName__First_last__Has_correct_full_name() {
/* DON'T TOUCH! */    String expected = "Bill Gates";
/* DON'T TOUCH! */    assertEquals(expected, personFirstLast.fullName());
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */}
