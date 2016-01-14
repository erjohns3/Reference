import java.util.Scanner;

public class DemoMostWantedHolder {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int smallest = 999999999;	// this is the most-wanted holder
		
		System.out.print("Please enter a number (-1 to end): ");
		int x = keyboard.nextInt();
		
		while (x != -1) {
			
			// do something with x (sum it, find the minimum, see if it's a "t"
			if (x < smallest) 
				smallest = x;
			
			System.out.print("Please enter a number (-1 to end): ");
			x = keyboard.nextInt();
		}
		
		System.out.println(smallest);
		
	}

}
