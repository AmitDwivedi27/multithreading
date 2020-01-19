package multithreadingworld.deadlock;

import java.math.BigDecimal;

public class Transaction implements Runnable{
	
	private String trnId;
	private Account from;
	private Account to;
	private BigDecimal amount;
	
	

	public Transaction(String trnId, Account from, Account to, BigDecimal amount) {
		super();
		this.trnId = trnId;
		this.from = from;
		this.to = to;
		this.amount = amount;
	}



	@Override
	public void run() {
		synchronized (from) {
			from.withdraw(amount);
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException e) {
				
			}
			synchronized (to) {
				to.deposit(amount);
			}
			
		}
		   System.out.println(amount + "is transfered from " + from + " to " + to);
	}

}
