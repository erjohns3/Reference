// step 1, implement Runnable
public class SortIntArray implements Runnable { 
	private int[] list;
	private int id;
	
	public SortIntArray(int size, int id) {
		this.id = id;
		list = new int[size];
		for (int i = 0; i < list.length; i++) 
			list[i] = (int)(Math.random()*Integer.MAX_VALUE);
	}
	
	// step 2, write the run method
	// this code will execute in a separate java thread
	public void run() {	 
		selectionSort();
	}
	
	public void selectionSort() {
	  long start = System.nanoTime();
	  int minIndex;
	  for (int i=0; i < list.length-1; i++) {
		if (i%(list.length/10) == 0)
			System.out.println(id + " is " + 
					i*100/list.length + " % through");
	    //find smallest element in list starting at location i
	    minIndex = i;
	    for (int j = i+1; j < list.length; j++)
	      if (list[j] < list[minIndex])
	        minIndex = j;

	    //swap list[i] with smallest element
	    int temp = list[i];
	    list[i] = list[minIndex];
	    list[minIndex] = temp;
	  }
	  System.out.println((System.nanoTime()-start)/1000000000.0);


	} 
	
	
	

}
