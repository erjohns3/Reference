import java.util.*;

public class SearchingAndSorting {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
	}

	/************************************************************************/
	// precondition: list is an instantiated array
	// postcondition: sets every int in list to a value between 101 and 200
	/************************************************************************/
	public static void load(int[] list) {
		for (int i = 0; i<list.length; i++) {
			list[i] = (int)(Math.random()*100) + 101;	// random value between 101 and 200
		}
	}

	/************************************************************************/
	// precondition: list is an instantiated array
	// postcondition: all elements of list are printed on the screen
	/************************************************************************/
	public static void print(int[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " " );
		}
		System.out.println();
	}

}

