import java.util.*;
public class Variables1 {

	public static void main(String[] args) {
		// set up the keyboard
		Scanner keyboard = new Scanner(System.in);
		
		int age;
		System.out.print("Enter your age: ");
		age = keyboard.nextInt();
		System.out.println("So you're " + age + " years old");
		System.out.println("Born in " + (2012-age));
		
		final double payRate;	// final means the value 
		 						// change.  It's a constant
		int hours;
		
		payRate = 8.75;
		hours = 30;
		
		payRate = 10.98;
		hours = 40;
		
	}

}
