import java.io.*;
public class Demo2DArray {
	public static void main(String[] args) throws IOException {

		int[][] nums = new int[50][10];

		/***************************************************************************************/
		/*  Don't change this                                                                  */
		/***************************************************************************************/
		System.out.println("Loading the 2D array...");
		BufferedReader in = new BufferedReader(new FileReader("numbers.txt"));
		String line = in.readLine();
		int x = 0;
		while (line != null) {
			String[] s = line.split(" ");
			for (int j = 0; j < s.length; j++) {
				nums[x][j] = Integer.parseInt(s[j]);
			}
			line = in.readLine();
			x++;
		}
		System.out.println("Done loading the 2D array");
	
		/***************************************************************************************/
		/* nums is an int[][] - a two dimensional array (or an array of arrays)                */
		/***************************************************************************************/

				
	}
}