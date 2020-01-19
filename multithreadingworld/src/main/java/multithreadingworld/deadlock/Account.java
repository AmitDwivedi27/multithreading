package multithreadingworld.deadlock;

import java.math.BigDecimal;

public class Account {

	private String accountNumber;
	private BigDecimal balance;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void withdraw(BigDecimal amount) {
		if (balance.compareTo(amount) > 0) {
			System.out.println(accountNumber + "  Current account balance is before withdrawal " + balance.toBigInteger());
			balance = balance.subtract(amount);
			System.out
					.println(accountNumber + "  Current account balance after withdrawal is " + balance.toBigInteger());

		}
	}

	public void deposit(BigDecimal amount) {
		if (amount.compareTo(new BigDecimal("0")) > 0) {
			System.out.println(accountNumber + "  Current account balance is before deposit " + balance.toBigInteger());
			balance = balance.add(amount);
			System.out.println(accountNumber + "  Current account balance after deposit is " + balance.toBigInteger());
		}
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Account(String accountNumber, BigDecimal balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}
	
	

}
