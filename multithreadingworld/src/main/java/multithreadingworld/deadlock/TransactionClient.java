package multithreadingworld.deadlock;

import java.math.BigDecimal;

public class TransactionClient {

	public static void main(String[] args) throws InterruptedException {
		
		Account accountA = new Account("Account A ", new BigDecimal("1000"));
		Account accountB = new Account("Account B ", new BigDecimal("2000"));
		
		
		Transaction transactionFirst = new Transaction("first", accountA, accountB, new BigDecimal("100"));
		Transaction transactionSecond = new Transaction("second", accountB, accountA, new BigDecimal("100"));
		
		new Thread(transactionFirst).start();
		new Thread(transactionSecond).start();
		
		Thread.sleep(6000);
		
		System.out.println(accountA);
		System.out.println(accountB);

	}

}
