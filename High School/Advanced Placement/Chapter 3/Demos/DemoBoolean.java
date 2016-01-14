public class DemoBoolean {

	public static void main(String[] args) {

		// declare two boolean variables
		boolean a;
		boolean b;
		
		// set them
		a = true;
		b = false;
		
		// print them
		System.out.println("a is " + a);
		System.out.println("b is " + b);
		
		// test them
		if (a)
			System.out.println("this will print");
		
		if (b)
			System.out.println("this won't print");
		
		if (a && b) 
			System.out.println("This won't print");
		
		if (a || b) 
			System.out.println("This will print");
		
		if (a && !b)
			System.out.println("This will print");
		
		
		
		
		
			
		
		
		
		
	}

}
