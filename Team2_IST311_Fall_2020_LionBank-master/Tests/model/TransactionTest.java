/* DON'T TOUCH! */package model;
/* DON'T TOUCH! */
/* DON'T TOUCH! */import org.junit.Test;
/* DON'T TOUCH! */import static org.junit.Assert.assertEquals;
/* DON'T TOUCH! */
/* DON'T TOUCH! */public class TransactionTest
/* DON'T TOUCH! */{
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void toString__create_Deposit__returns_correct_String() {
/* DON'T TOUCH! */    Transaction trans = new Transaction(Transaction.TransactionType.WITHDRAW, Transaction.TransactionStatus.SUCCESS, "some message");
/* DON'T TOUCH! */    Identifier id = trans.getId();
/* DON'T TOUCH! */
/* DON'T TOUCH! */    String expected = id + "|WITHDRAW|SUCCESS|some message";
/* DON'T TOUCH! */    assertEquals(expected, trans.toString());
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */}
