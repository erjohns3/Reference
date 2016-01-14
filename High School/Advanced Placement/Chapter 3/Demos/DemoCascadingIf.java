import java.util.*;

public class DemoCascadingIf {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter an Earthquake Strength: ");
		double richter = keyboard.nextDouble();

		if (richter >= 8.0) {
			System.out.println("Most structures fall");
		}
		else if (richter >= 7.0) {
			System.out.println("Many buildings destroyed");
		}
		else if (richter >= 6.0) {
			System.out.println("Many buildings considerable damaged, some collapse");
		}
		else if (richter >= 4.5) {
			System.out.println("Damage to poorly constructed buildings");
		}
		else if (richter >= 3.5) {
			System.out.println("Felt by mmany people, no destruction");
		}
		else if (richter >= 0) {
			System.out.println("Generally not felt by people");
		}
		else {
			System.out.println("Negative numbers are not valid");
		}
	}
}
