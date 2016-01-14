public class DemoRecursion {

	public static void main(String[] args) {
		//method1(12);
		System.out.println(factorialIter(10));
		System.out.println(factorialRecur(10));
	}

	public static int factorialIter(int num) {
		int total = 1;
		for (int k = 1; k <= num; k++) 
			total *= k;
		return total;
	}
	
	public static int factorialRecur(int num) {
		if (num==0)
			return 1;
		else		// assume n is not neg
			return factorialRecur(num-1)*num;
	}		
	
	
	
	
	
	
	
	
	
	
	public static void method1(int num) {
		System.out.println("I'm starting: " + num);
		if (num>0)
			method1(num-1);
		else {
			// do nothing, let the method finish
		}
		System.out.println("I'm ending: " + num);
		
	}
	
}
