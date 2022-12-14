package model;

import org.joda.money.Money;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BankAccount implements IBankAccount
{
  private Identifier id;
  private String accountName;
  private AccountType accountType;
  private Money balance = Money.parse("USD 0");

  private BankAccount() {
    /*
     * Private default constructor to force instantiators to pass in the
     * required field values
     */
  }

  public BankAccount(String name, AccountType accountType) {
    this.id = new Identifier();
    // TODO BankAccount.java 01 + Set fields from the given arguments
    // Scott Crowthers (scc5336@psu.edu)
    accountName = name;
    this.accountType = accountType;
  }

  @Override
  public Money getBalance() {
    // TODO BankAccount.java 02 + Implement getBalance()
    // Scott Crowthers (scc5336@psu.edu)
    return balance;
  }

  @Override
  public Transaction deposit(Money amount) {
    // TODO BankAccount.java 03 + Implement deposit
    // Scott Crowthers (scc5336@psu.edu)
    if(amount.isNegativeOrZero()){
      return new Transaction(Transaction.TransactionType.DEPOSIT, Transaction.TransactionStatus.FAILURE);
    }
    else {
      balance = balance.plus(amount);
      return new Transaction(Transaction.TransactionType.DEPOSIT, Transaction.TransactionStatus.SUCCESS);
    }
  }

  @Override
  public Transaction withdraw(Money amount) {
    // TODO BankAccount.java 04 + Implement withdraw
    // Scott Crowthers (scc5336@psu.edu)
    if(amount.isNegativeOrZero() || balance.minus(amount).isNegative()){
      return new Transaction(Transaction.TransactionType.WITHDRAW, Transaction.TransactionStatus.FAILURE);
    }
    else{
      balance = balance.minus(amount);
      return new Transaction(Transaction.TransactionType.WITHDRAW, Transaction.TransactionStatus.SUCCESS);
    }
  }

  @Override
  public Transaction transfer(Money amount, IBankAccount to) {
    // TODO BankAccount.java 05 + Implement transfer
    // Scott Crowthers (scc5336@psu.edu)
    if(amount.isNegativeOrZero() || balance.minus(amount).isNegative()){
      return new Transaction(Transaction.TransactionType.TRANSFER, Transaction.TransactionStatus.FAILURE);
    }
    else{
      balance = balance.minus(amount);
      to.deposit(amount);
      return new Transaction(Transaction.TransactionType.TRANSFER, Transaction.TransactionStatus.SUCCESS);
    }
  }

  @Override
  public AccountType getAccountType() {
    // TODO BankAccount.java 06 + Implement getAccountType
    // Scott Crowthers (scc5336@psu.edu)
    return accountType;
  }

  @Override
  public String getAccountName() {
    // TODO BankAccount.java 07 + Implement getAccountName
    // Scott Crowthers (scc5336@psu.edu)
    return accountName;
  }
}
