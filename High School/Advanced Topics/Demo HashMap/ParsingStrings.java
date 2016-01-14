import java.io.*;
import java.util.*;
public class ParsingStrings {

	public static void main(String[] args) throws Throwable  {

		/********************************************************/
		/* String.split() and Integer.parseInt() are useful     */
		/********************************************************/
		File counties = new File("counties.txt");
		File pop = new File("countyPopulationStats.txt");
		
		BufferedReader in = new BufferedReader(new FileReader(pop));
		String line = in.readLine();
		int accum = 0;
		double growAccum = 0;
		int count = 0;
		
		while (line != null) {
			String[] parts = line.split(",");
			String s = parts[0];
			if (!s.equals("fips") && !s.substring(2).equals("000")) {
				// it's a good one
				int p = Integer.parseInt(parts[1]);
				double g = Double.parseDouble(parts[3]);
				accum += p;
				growAccum += g;
				count++;
			}
			
			line = in.readLine();
		}
		System.out.println(accum);
		System.out.println(growAccum/count);

		/******************************************/
		/* HashMap                                */
		/******************************************/
		HashMap<String, String> myMap = new HashMap<String, String>();  
		myMap.put("304-16", "SAM");	// puts a key value pair on the hash map
		myMap.put("304-15", "SEAN");
		myMap.put("304-14", "ERIC");
		myMap.put("304-13", "SCOTT");
		myMap.put("304-12", "RYAN");
		myMap.put("304-17", "CODY");
		
		// lookup something up
		System.out.println(myMap.get("304-14"));
		
		// how many mapping do i have?
		System.out.println(myMap.size());
		
		// Get rid of RYAN
		myMap.remove("304-12");
		
		// get a List of all the keys
		Set<String> keys = myMap.keySet();
		for (String key : keys) {
			System.out.print(key + " ");
		}
		System.out.println();
		
		// get a List of all the values
		Collection<String> values = myMap.values();
		for (String value : values) {
			System.out.print(value + " ");
		}
		System.out.println();
		
		// see if a value is in the list
		System.out.println(myMap.containsValue("BYRON"));
		System.out.println(myMap.containsValue("ERIC"));
		
		// see if a key is in the list
		System.out.println(myMap.containsKey("304-01"));
		System.out.println(myMap.containsKey("304-14"));
		
		// put replaces items - duplicate keys not allowed
		System.out.println(myMap);
		String s = myMap.put("304-13", "GHOST");
		System.out.println(myMap);
		System.out.println("Old value was: " + s);
		
		// are duplicate values allowed? yes!
		myMap.put("303-15", "SEAN");
		System.out.println(myMap);
		
		
	}

	
	
	
	
	
	
	
}
