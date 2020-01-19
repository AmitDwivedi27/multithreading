package multithreadingworld.oddeven;

public class OddEvenPrinter {

	private int start;
	private int max;

	public OddEvenPrinter(int start, int max) {
		super();
		this.start = start;
		this.max = max;
	}

	public synchronized void printOdd() {
		while (start <= max) {
			if (start % 2 != 0) {
				System.out.println(start++);
				this.notify();
			} else {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	public synchronized void printEven() {
		while (start <= max) {
			if (start % 2 == 0) {
				System.out.println(start++);
				this.notify();
			} else {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

}
