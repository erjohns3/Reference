import java.util.*;
public class DemoIf {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		
		// To increase or decrease a variable
		int y = 5;
		y = y * 2;		// doubles y
		y = y - 4;		// decreases y by 4
		y = y + 7;		// increase y by 7
		System.out.println(y);
		
		y += 7;			// another way to increase y by 7
		System.out.println(y);
		
		// execute a statement conditionally
		System.out.print("Please enter your age: " );
		int age = keyboard.nextInt();
		
		if (age == 18) {
			System.out.println("You just became old enough to vote");
		}
		
		if (age >= 18) {
			System.out.println("Congrats, you can vote");
		}
		else {
			int yearsToVote = 18 - age;
			System.out.println("You have " + yearsToVote + 
										" years before you can vote");
		}
		
		// multiple mutually exclusive options
		System.out.print("What place did you come in: ");
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}

}
