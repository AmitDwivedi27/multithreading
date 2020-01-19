package multithreadingworld.oddeven;

public class OddEvenClient {
	
	public static void main(String[] args) {
		OddEvenPrinter oddEvenPrinter = new OddEvenPrinter(2, 10);
		new Thread(new OddPrinter(oddEvenPrinter)).start();
		new Thread(new EvenPrinter(oddEvenPrinter)).start();
	}

}
