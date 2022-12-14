package model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static util.Obj.coalesce;

public class Transaction {
    public enum TransactionType {
        DEPOSIT,
        WITHDRAW,
        TRANSFER
    }

    public enum TransactionStatus {
        PENDING_PROCESS,
        SUCCESS,
        FAILURE
    }

    private Identifier id;
    private TransactionType transType;
    private TransactionStatus transStatus;
    private String message;

    public Transaction(TransactionType transType, TransactionStatus transStatus) {
        this(transType, transStatus, null);
    }


    public Transaction(TransactionType transType, TransactionStatus transStatus, String message) {
        this.message = coalesce(message, "");
        this.id = new Identifier();
        this.transType = transType;
        this.transStatus = transStatus;


        // TODO Transaction.java 01 + Finish initializing
        // Kush Dave (kfd5176@psu.edu)
    }

    public Identifier getId() {

        // TODO Transaction.java 02 + Implement getId()
        // Kush Dave (kfd5176@psu.edu)
        return this.id;
    }

    public TransactionType getTransType() {
        // TODO Transaction.java 03 + Implement getTransType()
        // Kush Dave (kfd5176@psu.edu)
        return this.transType;
    }

    public TransactionStatus getTransStatus() {
        // TODO Transaction.java 04 + Implement getTransStatus()
        // Kush Dave (kfd5176@psu.edu)
        return this.transStatus;
    }


    @Override

    public String toString() {
        // TODO Transaction.java 05 + Implement toString()
        // Kush Dave (kfd5176@psu.edu)
        return id + "|" + transType + "|" + transStatus + "|" + message;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Transaction.java 06 + Implement equals(Object)
        // Kush Dave (kfd5176@psu.edu)

        // If they refer to the same instance, then they're definitely equal
        if (this == obj) return true;

        // If the object is not a Transaction, then there's no way they're equal
        if (!(obj instanceof Transaction)) return false;

        // At this point, we know we can cast it to Transaction
        // It's common refer to instance you want to compare as "that"
        Transaction that = (Transaction) obj;

        /*
         * All the fields must match for this and that to be considered equal
         */
        if (!this.id.equals(that.id)) return false;
        if (!this.transType.equals(that.transType)) return false;
        if (!this.transStatus.equals(that.transStatus)) return false;
        if (!this.message.equals(that.message)) return false;

        // If we got this far, then we consider the two objects entirely equal
        return true;

    }

}




