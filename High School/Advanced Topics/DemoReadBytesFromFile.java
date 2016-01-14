import java.io.*;

public class DemoReadBytesFromFile {

	public static void main(String[] args) {
		
		FileInputStream inFile = null;
		try {		// try to execute some code that has the potential
					// to throw an exception
			// open a file on disk for reading
			inFile = new FileInputStream("bbhInt.txt");
			System.out.println("I found the file");
			int x = inFile.read();	// read() will return -1 after the
			while (x != -1) {
				char c = (char)x;
				System.out.println(x);
				x = inFile.read();
			}
			
		}
		catch(FileNotFoundException fne) {	// jump here if an exception occurs
			System.out.println("Hey, that file is not found");
		}
		catch(IOException ioe) {
			System.out.println("An IOException occured");
			System.out.println(ioe);
			ioe.printStackTrace();
			
		}
		finally {	// always execute this whether an exception occurs
					// or not.  Let's you clean things up.
			System.out.println("This happens no matter what");
			try{inFile.close();}
			catch(Exception ioe){}
			
		}

		
		
		
		
		
		
		
		
	}

}
