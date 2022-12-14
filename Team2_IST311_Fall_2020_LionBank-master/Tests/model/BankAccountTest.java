/* DON'T TOUCH! */package model;
/* DON'T TOUCH! */
/* DON'T TOUCH! */import org.joda.money.Money;
/* DON'T TOUCH! */
/* DON'T TOUCH! */import org.junit.*;
/* DON'T TOUCH! */
/* DON'T TOUCH! */import static model.IBankAccount.AccountType.*;
/* DON'T TOUCH! */import static model.Transaction.TransactionStatus.*;
/* DON'T TOUCH! */
/* DON'T TOUCH! */import static org.junit.Assert.*;
/* DON'T TOUCH! */
/* DON'T TOUCH! */public class BankAccountTest
/* DON'T TOUCH! */{
/* DON'T TOUCH! */  IBankAccount checkingAccountStartingEmpty;
/* DON'T TOUCH! */  IBankAccount savingsAccountStartingEmpty;
/* DON'T TOUCH! */  IBankAccount checkingAccountStarting100;
/* DON'T TOUCH! */  IBankAccount savingsAccountStarting100;
/* DON'T TOUCH! */
/* DON'T TOUCH! */  String[] validAmounts = { "1.23", "1.0", "9.99" };
/* DON'T TOUCH! */  String[] invalidAmounts = { "0", "-1.23", "-1.0", "-99.99" };
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Before
/* DON'T TOUCH! */  public void setUp() throws Exception {
/* DON'T TOUCH! */    // System.out.println("setup");
/* DON'T TOUCH! */    checkingAccountStartingEmpty = new BankAccount("Checking Starting Empty", CHECKING);
/* DON'T TOUCH! */    savingsAccountStartingEmpty = new BankAccount("Savings Starting Empty", SAVINGS);
/* DON'T TOUCH! */
/* DON'T TOUCH! */    Money amount = Money.parse("USD 100.00");
/* DON'T TOUCH! */    checkingAccountStarting100 = new BankAccount("Checking Starting With $100", CHECKING);
/* DON'T TOUCH! */    checkingAccountStarting100.deposit(amount);
/* DON'T TOUCH! */    savingsAccountStarting100 = new BankAccount("Savings Starting With $100", SAVINGS);
/* DON'T TOUCH! */    savingsAccountStarting100.deposit(amount);
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @After
/* DON'T TOUCH! */  public void tearDown() throws Exception {
/* DON'T TOUCH! */    // System.out.println("tearDown");
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void ctor__Create_bank__Has_correct_content() {
/* DON'T TOUCH! */    BankAccount account = new BankAccount("My Checking", CHECKING);
/* DON'T TOUCH! */
/* DON'T TOUCH! */    assertEquals("My Checking", account.getAccountName());
/* DON'T TOUCH! */    assertEquals(CHECKING, account.getAccountType());
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void getBalance__Test_accounts__Return_correct_amt() {
/* DON'T TOUCH! */    Money zero = Money.parse("USD 0");
/* DON'T TOUCH! */    Money oneHundred = Money.parse("USD 100");
/* DON'T TOUCH! */
/* DON'T TOUCH! */    assertEquals(zero, checkingAccountStartingEmpty.getBalance());
/* DON'T TOUCH! */    assertEquals(zero, savingsAccountStartingEmpty.getBalance());
/* DON'T TOUCH! */
/* DON'T TOUCH! */    assertEquals(oneHundred, checkingAccountStarting100.getBalance());
/* DON'T TOUCH! */    assertEquals(oneHundred, savingsAccountStarting100.getBalance());
/* DON'T TOUCH! */
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void getBalance__Deposit_amt_to_empty_account__Returns_that_amt() {
/* DON'T TOUCH! */    String moneyStr = "123.45";
/* DON'T TOUCH! */    Money amount = Money.parse("USD " + moneyStr);
/* DON'T TOUCH! */
/* DON'T TOUCH! */    checkingAccountStartingEmpty.deposit(amount);
/* DON'T TOUCH! */    checkingAccountStartingEmpty.deposit(amount);
/* DON'T TOUCH! */
/* DON'T TOUCH! */    Money expected = amount.plus(amount);
/* DON'T TOUCH! */
/* DON'T TOUCH! */    assertTrue(expected.isEqual(checkingAccountStartingEmpty.getBalance()));
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void deposit__Valid_amts__Returns_success() {
/* DON'T TOUCH! */    for (String amt : validAmounts) {
/* DON'T TOUCH! */      Money amount = Money.parse("USD " + amt);
/* DON'T TOUCH! */      Transaction trans = checkingAccountStartingEmpty.deposit(amount);
/* DON'T TOUCH! */      assertEquals("Deposit $" + amt + " should succeed", SUCCESS, trans.getTransStatus());
/* DON'T TOUCH! */    }
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void deposit__Invalid_amts__Returns_failure() {
/* DON'T TOUCH! */    for (String amt : invalidAmounts) {
/* DON'T TOUCH! */      Money amount = Money.parse("USD " + amt);
/* DON'T TOUCH! */      Transaction trans = checkingAccountStartingEmpty.deposit(amount);
/* DON'T TOUCH! */      assertEquals("Deposit $" + amt + " should fail", FAILURE, trans.getTransStatus());
/* DON'T TOUCH! */    }
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void withdraw__Invalid_amt__Returns_failure() {
/* DON'T TOUCH! */    for (String amt : validAmounts) {
/* DON'T TOUCH! */      Money amount = Money.parse("USD " + amt);
/* DON'T TOUCH! */      Transaction trans = checkingAccountStartingEmpty.withdraw(amount);
/* DON'T TOUCH! */      assertEquals("Withdraw $" + amt + " should fail", FAILURE, trans.getTransStatus());
/* DON'T TOUCH! */    }
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void withdraw__Insufficient_amt__Returns_failure() {
/* DON'T TOUCH! */    for (String amt : validAmounts) {
/* DON'T TOUCH! */      Money amount = Money.parse("USD " + amt);
/* DON'T TOUCH! */      Transaction trans = checkingAccountStartingEmpty.withdraw(amount);
/* DON'T TOUCH! */      assertEquals("Withdraw $" + amt + " should fail", FAILURE, trans.getTransStatus());
/* DON'T TOUCH! */    }
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void withdraw__sufficient_valid_amt__Balance_is_correct() {
/* DON'T TOUCH! */    for (String amt : validAmounts) {
/* DON'T TOUCH! */      Money balanceBefore = checkingAccountStarting100.getBalance();
/* DON'T TOUCH! */      Money amount = Money.parse("USD " + amt);
/* DON'T TOUCH! */      Transaction trans = checkingAccountStarting100.withdraw(amount);
/* DON'T TOUCH! */      Money balanceAfter = checkingAccountStarting100.getBalance();
/* DON'T TOUCH! */      assertEquals("Withdraw $" + amt + " should succeed", SUCCESS, trans.getTransStatus());
/* DON'T TOUCH! */      assertEquals("Withdraw $" + amt + " unexpected balance after", balanceBefore.minus(amount), balanceAfter);
/* DON'T TOUCH! */    }
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void transfer__Invalid_amt__Returns_failure() {
/* DON'T TOUCH! */    for (String amt : invalidAmounts) {
/* DON'T TOUCH! */      Money amount = Money.parse("USD " + amt);
/* DON'T TOUCH! */      Transaction trans = checkingAccountStarting100.transfer(amount, savingsAccountStartingEmpty);
/* DON'T TOUCH! */      assertEquals("Withdraw $" + amt + " should fail", FAILURE, trans.getTransStatus());
/* DON'T TOUCH! */    }
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void transfer__insufficient_valid_amt__Returns_failure() {
/* DON'T TOUCH! */    IBankAccount source = checkingAccountStarting100;
/* DON'T TOUCH! */    IBankAccount target = savingsAccountStarting100;
/* DON'T TOUCH! */
/* DON'T TOUCH! */    Money amt = source.getBalance().plus(1.00);
/* DON'T TOUCH! */
/* DON'T TOUCH! */    Transaction trans = checkingAccountStarting100.transfer(amt, target);
/* DON'T TOUCH! */
/* DON'T TOUCH! */    assertEquals("Transfer $" + amt + " should fail", FAILURE, trans.getTransStatus());
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void transfer__sufficient_valid_amt__Balance_is_correct() {
/* DON'T TOUCH! */    IBankAccount source = checkingAccountStarting100;
/* DON'T TOUCH! */    IBankAccount target = savingsAccountStarting100;
/* DON'T TOUCH! */
/* DON'T TOUCH! */    for (String amt : validAmounts) {
/* DON'T TOUCH! */      Money checkingBalanceBefore = source.getBalance();
/* DON'T TOUCH! */      Money savingsBalanceBefore = target.getBalance();
/* DON'T TOUCH! */
/* DON'T TOUCH! */      Money amount = Money.parse("USD " + amt);
/* DON'T TOUCH! */      Transaction trans = source.transfer(amount, target);
/* DON'T TOUCH! */
/* DON'T TOUCH! */      Money checkingBalanceAfter = source.getBalance();
/* DON'T TOUCH! */      Money savingsBalanceAfter = target.getBalance();
/* DON'T TOUCH! */
/* DON'T TOUCH! */      assertEquals("Transfer $" + amt + " should succeed", SUCCESS, trans.getTransStatus());
/* DON'T TOUCH! */
/* DON'T TOUCH! */      assertEquals("Transfer $" + amt + " unexpected checking balance after", checkingBalanceBefore.minus(amount), checkingBalanceAfter);
/* DON'T TOUCH! */      assertEquals("Transfer $" + amt + " unexpected savings balance after", savingsBalanceBefore.plus(amount), savingsBalanceAfter);
/* DON'T TOUCH! */    }
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void getAccountType__Create_account__Returns_correct_account_type() {
/* DON'T TOUCH! */    assertEquals(CHECKING, checkingAccountStartingEmpty.getAccountType());
/* DON'T TOUCH! */    assertEquals(SAVINGS, savingsAccountStartingEmpty.getAccountType());
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */
/* DON'T TOUCH! */  @Test
/* DON'T TOUCH! */  public void getAccountName__Create_account__Returns_correct_account_name() {
/* DON'T TOUCH! */    assertEquals("Checking Starting Empty", checkingAccountStartingEmpty.getAccountName());
/* DON'T TOUCH! */    assertEquals("Savings Starting Empty", savingsAccountStartingEmpty.getAccountName());
/* DON'T TOUCH! */  }
/* DON'T TOUCH! */}
