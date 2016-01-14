public class PiSlow {

	public static final int N = 500000000; // # of terms

	public static void main(String[] args) {
		double sum = 0.0;      // final sum
		double term;           // term without sign
		double sign = 1.0;     // sign on each term
		for (int k = 0; k < N; k++) {
			term = 1.0/(2.0*k + 1.0);
			sum = sum + sign*term;
			if (k%(N/10) == 0) // print one in 50
				System.out.println("Gregory's Series: \t" + k/(N/100) + "% done");
			sign = -sign;
		}
		//System.out.println("Final pi/4 (approx., " +
		//N + " terms): " + sum);
		//System.out.println("Actual pi/4: " +
		//Math.PI/4.0);
		System.out.println("Gregory's Answer: (" + N + " terms): " + sum*4.0);
		//System.out.println("Actual pi: " + Math.PI);
	}
}
