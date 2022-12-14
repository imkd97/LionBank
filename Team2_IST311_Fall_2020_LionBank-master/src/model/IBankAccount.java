/* DON'T TOUCH! */ package model;
/* DON'T TOUCH! */ 
/* DON'T TOUCH! */ import org.joda.money.Money;
/* DON'T TOUCH! */ 
/* DON'T TOUCH! */ public interface IBankAccount
/* DON'T TOUCH! */ {
/* DON'T TOUCH! */ 
/* DON'T TOUCH! */   enum AccountType
/* DON'T TOUCH! */   {
/* DON'T TOUCH! */     CHECKING,
/* DON'T TOUCH! */     SAVINGS,
/* DON'T TOUCH! */     VACATION
/* DON'T TOUCH! */   }
/* DON'T TOUCH! */ 
/* DON'T TOUCH! */   String getAccountName();
/* DON'T TOUCH! */   AccountType getAccountType();
/* DON'T TOUCH! */   Money getBalance();
/* DON'T TOUCH! */   Transaction deposit(Money amount);
/* DON'T TOUCH! */   Transaction withdraw(Money amount);
/* DON'T TOUCH! */   Transaction transfer(Money amount, IBankAccount to);
/* DON'T TOUCH! */ }
