/*We have all come across ATMs in our cities and it is built on Java. This complex project consists of
five different classes and is a console-based application. When the system starts the user is
prompted with user id and user pin. On entering the details successfully, then ATM functionalities
are unlocked. The project allows to perform following operations:

Transactions History
Withdraw
Deposit
Transfer
Mini Statement
Quit */

import java.util.Scanner;

class Bank extends main{
	
	  private int userId;
	  private int pin;
	  private double balance;
	  private Transaction[] transactions;
	  private int transactionIndex;

	  public Bank(int userId, int pin, double initialBalance) {
	    this.userId = userId;
	    this.pin = pin;
	    this.balance = initialBalance;
	    this.setTransactions(new Transaction[10]);
	    this.transactionIndex = 0;
	  }

	  public int getUserId() {
	    return userId;
	  }

	  public int getPin() {
	    return pin;
	  }

	  public double getBalance() {
	    return balance;
	  }

	  public void withdraw(double amount) {
	    if (balance >= amount) {
	      balance -= amount;
	      getTransactions()[transactionIndex++] = new Transaction(Transaction.Type.WITHDRAW, amount);
	    }
	  }

	  public void deposit(double amount) {
	    balance += amount;
	    getTransactions()[transactionIndex++] = new Transaction(Transaction.Type.DEPOSIT, amount);
	  }

	  public void transfer(Bank recipient, double amount) {
	    if (balance >= amount) {
	      balance -= amount;
	      recipient.deposit(amount);
	      getTransactions()[transactionIndex++] = new Transaction(Transaction.Type.TRANSFER, amount);
	    }
	  }

	  public void displayMinistatement() {
	    System.out.println("Mini Statement:");
	    for (int i = transactionIndex - 1; i >= 0 && i >= transactionIndex - 5; i--) {
	      System.out.println(getTransactions()[i].toString());
	    }
	  }

	public void setTransactions(Transaction[] transactions) {
		this.transactions = transactions;
	}

	public Transaction[] getTransactions() {
		return transactions;
	}
	}

	class Transaction {
	  enum Type {
	    WITHDRAW,
	    DEPOSIT,
	    TRANSFER
	  }

	  private Type type;
	  private double amount;

	  public Transaction(Type type, double amount) {
	    this.type = type;
	    this.amount = amount;
	  }

	  @Override
	  public String toString() {
	    return "Transaction{" +
	      "type=" + type +
	      ", amount=" + amount +
	      '}';
	  }
	}

	class ATM {
	  private Bank bank;

	  public ATM(Bank bank) {
	    this.bank = bank;
	  }

	  public void start() {
	    Scanner sc = new Scanner(System.in);

	    System.out.print("Enter user id: ");
	    int userId = sc.nextInt();
	    System.out.print("Enter pin: ");
	    int pin = sc.nextInt();

	    if (bank.getUserId() == userId && bank.getPin() == pin) {
	      System.out.println("Access granted.");

	      System.out.println("Select an option:");
	      System.out.println("1. Transactions History");
	      System.out.println("2. Withdraw");
	      System.out.println("3. Deposit");
	      System.out.println("4. Transfer");
	      System.out.println("5. Mini Statement");
	      System.out.println("6. Quit");
	      int option = sc.nextInt();
	      while (option != 6) {
	          switch (option) {
	            case 1:
	              System.out.println("Transactions History:");
	              for (Transaction transactions : bank.getTransactions()) {
	                System.out.println(transactions.toString());
	              }
	              break;
	            case 2:
	              System.out.print("Enter amount to withdraw: ");
	              double withdrawAmount = sc.nextDouble();
	              bank.withdraw(withdrawAmount);
	              System.out.println("Withdrawal successful.");
	              break;
	            case 3:
	              System.out.print("Enter amount to deposit: ");
	              double depositAmount = sc.nextDouble();
	              bank.deposit(depositAmount);
	              System.out.println("Deposit successful.");
	              break;
	            case 4:
	              System.out.print("Enter recipient user id: ");
	              int recipientUserId = sc.nextInt();
	              System.out.print("Enter amount to transfer: ");
	              double transferAmount = sc.nextDouble();
	              Bank recipient = new Bank(recipientUserId, 1234, 0);
	              bank.transfer(recipient, transferAmount);
	              System.out.println("Transfer successful.");
	              break;
	            case 5:
	              bank.displayMinistatement();
	              break;
	            default:
	              System.out.println("Invalid option.");
	          }

	          System.out.println("Select an option:");
	          System.out.println("1. Transactions History");
	          System.out.println("2. Withdraw");
	          System.out.println("3. Deposit");
	          System.out.println("4. Transfer");
	          System.out.println("5. Mini Statement");
	          System.out.println("6. Quit");
	          option = sc.nextInt();
	        }

	        System.out.println("Thank you for using our ATM. Have a great day!");
	      } else {
	        System.out.println("Access denied. Incorrect user id or pin.");
	      }
	    }
	  }
