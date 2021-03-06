import java.math.BigDecimal;
import java.math.BigInteger;
import java.io.*;

public class Bigpi {

	public static final int N = 2800; // # of decimals to calculate PI to

	public static void main(String args[]) throws IOException {

		String I1, I2, If;
		BigDecimal one, sixteen, four, oneby5, oneby239, atn15, atn239, xsq, powercum, bigpi;

		PrintWriter dos = new PrintWriter(System.out, true);
		//System.out.println("         ------------------------------------    ");
		//System.out.println("          Calculation of Pi by Machin method    ");
		//System.out.println("         ------------------------------------   ");
		//System.out.println("                      by M. Gallant 10/16/97   ");
		//System.out.println("\n ");

		int tscale = N + 2;

		one = new BigDecimal("1");
		four = new BigDecimal("4");
		sixteen = new BigDecimal("16");
		oneby5 = new BigDecimal("0.2");
		oneby239 = one.divide(new BigDecimal("239"), tscale,
				BigDecimal.ROUND_DOWN);

		// calculate arctan(1/5) to tscale digits of precision:
		// Based on log10(1/5) need about 1.5*tscale maximum exponent.

		atn15 = oneby5; // initialize to first term of arctan series.
		powercum = oneby5; // start with first power.
		xsq = oneby5.multiply(oneby5);

		//System.out.println("Starting Calculation with " + tscale
		//		+ " terms ....\n");
		for (int i = 3; i <= (3 * tscale / 2); i += 4) {
			powercum = powercum.multiply(xsq);
			atn15 = atn15.subtract(powercum.divide(
					new BigDecimal(String.valueOf(i)), tscale,
					BigDecimal.ROUND_DOWN));
			powercum = powercum.multiply(xsq);
			atn15 = atn15.add(powercum.divide(
					new BigDecimal(String.valueOf(i + 2)), tscale,
					BigDecimal.ROUND_DOWN));
			atn15 = atn15.setScale(tscale, BigDecimal.ROUND_DOWN);
			if ((i-3)%(3*tscale/2/10) == 0) // print one in 50
				System.out.println("Machin Method: 1st Loop \t" + i/(3*tscale/2/100) + "% done");
		}

		// calculate arctan(1/239) to tscale digits of precision:
		// Based on log10(1/239) need about 0.5*tscale maximum exponent.
		atn239 = oneby239; // initialize to first term of arctan series.
		powercum = oneby239; // start with first power.
		xsq = oneby239.multiply(oneby239);

		for (int i = 3; i <= tscale / 2; i += 4) {
			powercum = (powercum.multiply(xsq)).setScale(tscale,
					BigDecimal.ROUND_DOWN);
			atn239 = atn239.subtract(powercum.divide(
					new BigDecimal(String.valueOf(i)), BigDecimal.ROUND_DOWN));
			powercum = (powercum.multiply(xsq)).setScale(tscale,
					BigDecimal.ROUND_DOWN);
			atn239 = atn239.add(powercum.divide(
					new BigDecimal(String.valueOf(i + 2)),
					BigDecimal.ROUND_DOWN));
			atn239 = atn239.setScale(tscale, BigDecimal.ROUND_DOWN);
			if ((i-3)%(tscale/2/10) == 0) // print one in 50
				System.out.println("Machin Method: 2nd Loop \t" + (i*10)/(tscale/2/10) + "% done");
		}

		bigpi = sixteen.multiply(atn15);
		bigpi = bigpi.subtract(four.multiply(atn239));

		System.out.println("BigPi (terms summed= " + tscale + ")\n" + bigpi);
		// System.out.println("\n\nPi: " + Math.PI) ;

		/*
		 * int index1=0 ; int index2=10;
		 * 
		 * while(index2<I1.length()) {
		 * System.out.println(I1.substring(index1,index2)) ; index1+=10;
		 * index2+=10; } System.out.println(I1.substring(index1,I1.length())) ;
		 */

	}
}