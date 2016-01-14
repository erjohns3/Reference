import java.io.*;
import java.net.*;

public class DemoServerSocket {
 
	public static void main(String[] args) {
		ServerSocket ss = null;
		PrintStream out = null;
		Socket sock = null;
		try {
			InetAddress addr = InetAddress.getLocalHost();
			System.out.println(addr.getHostName());
			System.out.println(addr.getHostAddress());
			
			
			ss = new ServerSocket(50000);
			sock = ss.accept();	// waits for a client!!!!!

			// now we can use the Socket to communicate with the client
			out = new PrintStream(sock.getOutputStream());
			String s = "<body bgcolor=\"#FF0000\"><h1>Hello There<h1></body>";
			out.println(s);
			
		}
		catch (UnknownHostException uhe) {
			System.out.println("Unknown Host");
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		finally {
			try {out.close();}
			catch (Throwable t) {}

			try {sock.close();}
			catch(IOException ioe1) {};
			
			try {ss.close();}
			catch(IOException ioe1) {};
		}
	}

}
