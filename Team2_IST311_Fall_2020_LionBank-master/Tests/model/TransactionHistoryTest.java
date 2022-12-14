/* DON'T TOUCH! */package model;
/* DON'T TOUCH! */
/* DON'T TOUCH! */import com.google.gson.Gson;
/* DON'T TOUCH! */import org.junit.Before;
/* DON'T TOUCH! */import org.junit.Test;
/* DON'T TOUCH! */
/* DON'T TOUCH! */import java.util.ArrayList;
/* DON'T TOUCH! */import java.util.Collection;
/* DON'T TOUCH! */import java.util.List;
/* DON'T TOUCH! */
/* DON'T TOUCH! */import static model.Transaction.TransactionStatus.*;
/* DON'T TOUCH! */import static model.Transaction.TransactionType.*;
/* DON'T TOUCH! */import static org.junit.Assert.*;
/* DON'T TOUCH! */
/* DON'T TOUCH! */public class TransactionHistoryTest
/* DON'T TOUCH! */{
/* DON'T TOUCH! */  private TransactionHistory transHist = TransactionHistory.getInstance();
/* DON'T TOUCH! */
/* DON'T TOUCH! */  Transaction[] testTransactions = {
/* DON'T TOUCH! */      new Transaction(WITHDRAW, FAILURE),
/* DON'T TOUCH! */      new Transaction(DEPOSIT, PENDING_PROCESS),
/* DON'T TOUCH! */      new Transaction(TRANSFER, SUCCESS)
/* DON'T TOUCH! */  };
/* DON'T TOUCH! */
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Before
/* DON'T TOUCH! */  public void setup() {
/* DON'T TOUCH! */    transHist.clear();
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void add__One_transaction__Correct_values() {
/* DON'T TOUCH! */    Transaction newTrans = new Transaction(WITHDRAW, FAILURE);
/* DON'T TOUCH! */    transHist.add(newTrans);
/* DON'T TOUCH! */    assertEquals(1, transHist.getCount());
/* DON'T TOUCH! */
/* DON'T TOUCH! */    Transaction gotTrans = transHist.getAll().get(0);
/* DON'T TOUCH! */
/* DON'T TOUCH! */    assertSame(newTrans, gotTrans);
/* DON'T TOUCH! */    assertEquals(WITHDRAW, gotTrans.getTransType());
/* DON'T TOUCH! */    assertEquals(FAILURE, gotTrans.getTransStatus());
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void getAll__Add_many_trans__Count_and_data_match() {
/* DON'T TOUCH! */    int numTrans = testTransactions.length;
/* DON'T TOUCH! */
/* DON'T TOUCH! */    List<Transaction> clonedTransactions = new ArrayList<>();
/* DON'T TOUCH! */
/* DON'T TOUCH! */    Gson gson = new Gson();
/* DON'T TOUCH! */    for (Transaction trans : testTransactions) {
/* DON'T TOUCH! */      Transaction clone = gson.fromJson(gson.toJson(trans), Transaction.class);
/* DON'T TOUCH! */      clonedTransactions.add(clone);
/* DON'T TOUCH! */      transHist.add(trans);
/* DON'T TOUCH! */    }
/* DON'T TOUCH! */
/* DON'T TOUCH! */    Iterable<Transaction> allTrans = transHist.getAll();
/* DON'T TOUCH! */    assertEquals("Counts should match", testTransactions.length, ((Collection<Transaction>) allTrans).size());
/* DON'T TOUCH! */    int idx = 0;
/* DON'T TOUCH! */    int idxNext = 1;
/* DON'T TOUCH! */    for (Transaction trans : allTrans) {
/* DON'T TOUCH! */      assertEquals("These transactions should match", clonedTransactions.get(idx), trans);
/* DON'T TOUCH! */      assertNotEquals("These transactions should not match", clonedTransactions.get(idxNext), trans);
/* DON'T TOUCH! */      idx++;
/* DON'T TOUCH! */      idxNext = (idx + 1) % numTrans;  // Point to a different transaction [round robin]
/* DON'T TOUCH! */    }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void clear__Add_transactions_then_clear__Count_is_zero() {
/* DON'T TOUCH! */    transHist.clear();
/* DON'T TOUCH! */    assertEquals(0, transHist.getCount());
/* DON'T TOUCH! */
/* DON'T TOUCH! */    for (Transaction trans : testTransactions) {
/* DON'T TOUCH! */      transHist.add(trans);
/* DON'T TOUCH! */    }
/* DON'T TOUCH! */
/* DON'T TOUCH! */    assertEquals(3, transHist.getCount());
/* DON'T TOUCH! */
/* DON'T TOUCH! */    transHist.clear();
/* DON'T TOUCH! */    assertEquals(0, transHist.getCount());
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void getMostRecent__Add_transactions__Returns_most_recent() {
/* DON'T TOUCH! */    for (Transaction trans : testTransactions) {
/* DON'T TOUCH! */      transHist.add(trans);
/* DON'T TOUCH! */    }
/* DON'T TOUCH! */
/* DON'T TOUCH! */    assertEquals(testTransactions[2], transHist.getMostRecent());
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */}
