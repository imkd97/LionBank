/* DON'T TOUCH! */package util;
/* DON'T TOUCH! */
/* DON'T TOUCH! */import org.junit.Test;
/* DON'T TOUCH! */
/* DON'T TOUCH! */import static org.junit.Assert.*;
/* DON'T TOUCH! */
/* DON'T TOUCH! */public class StringUtilTest
/* DON'T TOUCH! */{
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void isNullOrEmpty__Pass_null__Returns_true() {
/* DON'T TOUCH! */    assertTrue(StringUtil.isNullOrEmpty(null));
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void isNullOrEmpty__Pass_empty__Returns_true() {
/* DON'T TOUCH! */    assertTrue(StringUtil.isNullOrEmpty(""));
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void isNullOrWhitespace__Pass_null__Returns_true() {
/* DON'T TOUCH! */    assertTrue(StringUtil.isNullOrWhitespace(null));
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void isNullOrWhitespace__Pass_spaces__Returns_true() {
/* DON'T TOUCH! */    assertTrue(StringUtil.isNullOrWhitespace("   "));
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void isNullOrWhitespace__Pass_empty__Returns_true() {
/* DON'T TOUCH! */    assertTrue(StringUtil.isNullOrWhitespace(""));
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */}
