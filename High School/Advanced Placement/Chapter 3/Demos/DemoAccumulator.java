public class DemoAccumulator {

	public static void main(String[] args) {
		
		int accum = 0;
		
		for (int i = 0; i < 5; i++) {
			int die = (int)(Math.random()*6) + 1;
			accum = accum + die;
			System.out.println("You rolled a: " + die);
		}
		
		System.out.println("The total is: " + accum);
		
		// iterating through a string
		String s = "End of the 1st quarter!";
			      //01234567890123456789012
		
		for (int i = 0; i < s.length(); i++){
			
			String letter = s.substring(i, i+1);
			System.out.println(letter);
			
			
		}
		
		
		
		
		
		
		
		
		
	}

}
