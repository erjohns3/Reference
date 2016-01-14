public class Client {

	public static void main(String[] args) {
		SortIntArray s1 = new SortIntArray(50000, 1);
		SortIntArray s2 = new SortIntArray(50000, 2);
		SortIntArray s3 = new SortIntArray(50000, 3);
		
		//Step 3, create a Thread object using your Runnable
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		Thread t3 = new Thread(s3);
		
		long start = System.nanoTime();
		
		// Step 4, call Thread's start() method
		t1.start();
		t2.start();
		t3.start();

		try {
			t1.join();	// causes main() to wait for t1 to finish
			t2.join();	// causes main() to wait for t2 to finish
			t3.join();	// causes main() to wait for t2 to finish
		}
		catch (InterruptedException ie){}
		
		System.out.println("Master time: " + 
				(System.nanoTime()-start)/1000000000.0);
	}

}
