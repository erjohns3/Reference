import java.util.*;

public class DemoInteractingWithObjects {

	public static void main(String[] args) {
		String s1 = new String("Cold Winter Day");
		System.out.println(s1.charAt(6));
		System.out.println(s1.substring(5, 11));
		
		ArrayList<String> myList = new ArrayList<String>(  );
		myList.add("Banana");
		myList.add("Pizza");
		myList.add("Donut");
		myList.add("Pie");
		System.out.println(myList);
		System.out.println(myList.get(1));
		// get the 2nd to last
		System.out.println(myList.get( myList.size()- 2 ));
		
		String[] parts = s1.split(" ");
		for (String part : parts) {
			myList.add(part);
		}
		System.out.println(myList);
		
		
		
	}

}
