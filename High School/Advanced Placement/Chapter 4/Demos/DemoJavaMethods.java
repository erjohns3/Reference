public class DemoJavaMethods {

	public static void main(String[] args) {
		dog(5);
		dog(3);
		dog(0);
		int x = reverse(748);
		int y = reverse(7238098);
		System.out.println(x);
		System.out.println(y);
		System.out.println(x+y);
	}
	
	public static void dog(int numWoofs) {
		System.out.println("     /(");
		System.out.println("    //\\\\");
		System.out.println("   //   )_.-\"\"\"-._,-\"\"-.");
		System.out.println("   \\\\ ^,'_\\     /_\\     )");
		System.out.println("    `./ /O\\|   |/O\\\\   /");
		System.out.println("      \\ \\_/|   |\\_/ \\_/");
		System.out.println("       \\ .'  _  `. /");
		System.out.println("        ( .:(_):. )");
		System.out.println("         `._.-._,'   ");
		System.out.println("            `-'");
		for (int i = 0; i < numWoofs; i++) 
			System.out.print("Woof ");
		System.out.println();
	}
	
	public static int reverse(int num) {
		int accum = 0;
		while (num > 0) {
			int lastDigit = num % 10;
			accum = accum*10 + lastDigit;
			num = num / 10;
		}
		return accum;
		
	}
	
	
	
	

}
