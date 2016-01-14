import java.io.*;

public class DemoWriteBytesToFile {

	public static void main(String[] args) {
		
		FileOutputStream outFile = null;
		try {		// try to execute some code that has the potential
					// to throw an exception
			// open a file on disk for reading
			outFile = new FileOutputStream("test.txt", true);
			
			String s = "Hello!\nHow are you";
			for (int i = 0; i < s.length(); i++) {
				outFile.write(s.charAt(i));
			}
			
		}
		catch(IOException ioe) {
			System.out.println("An IOException occured");
			System.out.println(ioe);
			ioe.printStackTrace();
			
		}
		finally {	// always execute this whether an exception occurs
					// or not.  Let's you clean things up.
			System.out.println("This happens no matter what");
			try{outFile.close();}
			catch(Exception ioe){}
			
		}

		
		
		
		
		
		
		
		
	}

}
