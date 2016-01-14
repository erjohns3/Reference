import java.io.*;
import java.net.*;

public class DemoClientSocket {

	public static void main(String[] args) {
		Socket sock = null;
		PrintStream out = null;
		BufferedReader in = null;
		try {
			sock = new Socket("oprfhs.org", 80);
			out = new PrintStream(sock.getOutputStream());
			out.println("GET / HTTP/1.1");
			out.println();
			
			// Read the resposne
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			String s = in.readLine();
			while (s != null) {
				System.out.println(s);
				s = in.readLine();
			}
			
		}
		catch (UnknownHostException uhe) {
			System.out.println("Unknown Host");
		}
		catch (Throwable t) {	// all expcetions implement Throwable - catch all
			t.printStackTrace();
		}
		finally {
			try {in.close();}
			catch (Throwable t) {} 
			try {out.close();}
			catch (Throwable t){}
			try {sock.close();}
			catch (Throwable t){}
			
		}

		
	}

}
