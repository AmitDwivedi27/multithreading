package multithreadingworld.oddeven;

public class EvenPrinter implements Runnable {

	private OddEvenPrinter oddEvenPrinter;

	public EvenPrinter(OddEvenPrinter oddEvenPrinter) {
		super();
		this.oddEvenPrinter = oddEvenPrinter;
	}

	@Override
	public void run() {
		oddEvenPrinter.printEven();

	}

}
