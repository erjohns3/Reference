import java.util.*;
public class QuadraticEquation {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter a: " );
		int a = keyboard.nextInt();

		System.out.print("Enter b: " );
		int b = keyboard.nextInt();

		System.out.print("Enter c: " );
		int c = keyboard.nextInt();

		System.out.println();
		System.out.println("Root 1= " + (-b + Math.sqrt(b*b - 4*a*c))/(2*a));


	}
}
