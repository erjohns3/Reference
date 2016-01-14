import java.text.NumberFormat;
import java.util.*;
public class DemoIf {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		
		//////////////////////////////////////////
		// increasing and decreasing variables
		//////////////////////////////////////////
		int j = 5;
		j = j * 2;	// doubles j
		j = j - 2;	// decreases j by 2
		j = j + 7;	// increases j by 7
		System.out.println(j);
		
		j -= 2;		// decreases j by 2
		System.out.println(j);
		
		/////////////////////////////////////////
		// conditional statements
		////////////////////////////////////////
		System.out.print("Please enter your age: ");
		int age = keyboard.nextInt();
		if (age == 18) {
			System.out.println("You just became old enough to vote");
		}
		
		if (age >= 18) { 
			System.out.println("You can vote");
		}
		else { 
			int yearsToVote = 18 - age;
			System.out.println("Wait " + yearsToVote + " years");
		}
		
		
		/////////////////////////////////////////////
		// multiple mutually exclusive options
		/////////////////////////////////////////////
		System.out.print("What place did you come in? ");
		int place = keyboard.nextInt();
		
		String medal = "";
		if (place == 1) {
			medal = "Gold";
		}
		else if (place == 2) {
			medal = "Silver";
		}
		else if (place == 3) {
			medal = "Bronze";
		}
		else {
			medal = "No Medal for You";
		}
		
		System.out.println("You got: " + medal);
		

		// medal or no medal
		if (place == 1 || place == 2 || place == 3)
			System.out.println("You medaled");
		else
			System.out.println("No Medal for you");
	
		// another way 
		if (place >= 1 && place <= 3)
			System.out.println("You medaled");
		else
			System.out.println("No Medal for you");
		
				
		// suppose 100th gets a medal
		if ( (place >= 1 && place <= 3) || place == 100)
			System.out.println("You medaled");
		else
			System.out.println("You didn't medal");
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
