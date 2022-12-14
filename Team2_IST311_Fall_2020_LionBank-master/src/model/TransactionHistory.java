package model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionHistory
{
  private static final TransactionHistory INSTANCE = new TransactionHistory();
  private List<Transaction> history;

  private TransactionHistory() {
    this.history = Collections.synchronizedList(new ArrayList<>());
  }

  public static TransactionHistory getInstance() {
    return INSTANCE;
  }

  public void add(Transaction trans) {
    // TODO TransactionHistory.java 01 - implement add(Transaction)
    // Adama Doumbia (apd5392@psu.edu)
    this.history.add(trans);
  }

  public List<Transaction> getAll() {
    // TODO TransactionHistory.java 02 - implement getAll();
    // Adama Doumbia (apd5392@psu.edu)
    return this.history; }

  public Transaction getMostRecent() {
    // TODO TransactionHistory.java 03 - implement getMostRecent();
    // Adama Doumbia (apd5392@psu.edu)
    return this.history.get(2); }

  public void clear() {
    // TODO TransactionHistory.java 04 - implement clear();
    // Adama Doumbia (apd5392@psu.edu)
    this.history.clear();
  }

  public int getCount() {
    // TODO TransactionHistory.java 05 - implement getCount();
    // Adama Doumbia (apd5392@psu.edu)
    return this.history.size();

  }
}
