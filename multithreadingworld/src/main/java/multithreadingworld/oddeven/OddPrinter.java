package multithreadingworld.oddeven;

public class OddPrinter implements Runnable {

	private OddEvenPrinter oddEvenPrinter;

	public OddPrinter(OddEvenPrinter oddEvenPrinter) {
		super();
		this.oddEvenPrinter = oddEvenPrinter;
	}

	@Override
	public void run() {
		oddEvenPrinter.printOdd();

	}

}
