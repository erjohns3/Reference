public class SimpleArray {

	public static void main(String[] args) {
		// a bad way to store a list
		int score1 = 85;
		int score2 = 93;
		int score3 = 64;
		
		// use an array instead
		int[] scores = new int[5];
		scores[0] = 87;
		scores[1] = 73;
		scores[2] = 95;
		scores[3] = 64;
		scores[4] = 82;

		System.out.println("The first scores is " + scores[0]);
		
		System.out.println("The number of scores is " + scores.length);			
		
		System.out.println("The last score is " + scores[scores.length-1] );
		
		// print all the scores
		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i]);
		}
		
		
		
		
	}

}
