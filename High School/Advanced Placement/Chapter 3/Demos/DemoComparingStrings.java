import java.util.*;

public class DemoComparingStrings {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		/*
		int a,b;
		
		System.out.print("Please enter a number: ");
		a = keyboard.nextInt();
		
		System.out.print("Please enter another number: ");
		b = keyboard.nextInt();
		
		if (a == b) {
			System.out.println("The numbers are the same");
		}
		else {
			System.out.println("They're different");
		}
		
		if ( a != b ) {
			System.out.println("The numbers are not the same");
		}
		else {
			System.out.println("The numbers are the same");
		}
		
		if ( a > b  ) {
			System.out.println("The first one is bigger");
		}
		else if ( b > a  ) {
			System.out.println("The second one is bigger");
		}
		else {
			System.out.println("They are the same");
		}
		*/
		
		String a,b;
		
		System.out.print("Please enter a number: ");
		a = keyboard.next();
		
		System.out.print("Please enter another number: ");
		b = keyboard.next();
		
		if (a.equals(b)) {
			System.out.println("The numbers are the same");
		}
		else {
			System.out.println("They're different");
		}
		
		if ( !a.equals(b) ) {
			System.out.println("The numbers are not the same");
		}
		else {
			System.out.println("The numbers are the same");
		}
		
		if ( a.compareTo(b) > 0 ) {
			System.out.println("The first one is bigger");
		}
		else if ( b.compareTo(a) > 0 ) {
			System.out.println("The second one is bigger");
		}
		else {
			System.out.println("They are the same");
		}
		
		
	}

}
