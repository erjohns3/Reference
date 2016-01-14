import java.util.Scanner;

public class DemoWhile {

	public static void main(String[] args) {
		// We have two looping constructs: for and while
		
		Scanner keyboard = new Scanner(System.in);
		
		// sentinel value loop (-1 is the sentinel value)
		int i = keyboard.nextInt();
		while ( i != -1 ) {
			System.out.println(Math.pow(i, 2));
			i = keyboard.nextInt();
		}
	}

}
