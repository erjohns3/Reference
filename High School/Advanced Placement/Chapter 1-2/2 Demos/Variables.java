import java.util.*;

public class Variables {

	public static void main(String[] args) {

		// Sets up the keyboard 
		Scanner keyboard = new Scanner(System.in);
		
		int age;
		age = keyboard.nextInt();
		System.out.println("So you are " + age + " years old");
		System.out.println("You were born in " + (2012-age));
		
		final double payRate; // a number with decimals
							  // final means it can't change
							  // a constant
		
		int hours;
		
		payRate = 8.25;
		payRate = 9.25;		// payRate is final, it
							// can't be changed
		hours = 30;
		hours = 35;			// hours can be changed
		
		System.out.println("Total pay is $" + payRate*hours);
		
		
		
		
		
		
		
		
	}

}
