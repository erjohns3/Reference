import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WebClient {

	public static void main(String[] args) {
		Socket sock = null;
		PrintStream out = null;
		BufferedReader in = null;
		int numLow = 0;
		int numHigh = 0;
		String stringLow = "";
		String stringHigh = "";
		int num = 0;
		String message;
		int accum = 0;

		try {
			String name = "bitch squad";
			numLow = 0;
			numHigh = 0;
			stringLow = "";
			stringHigh = "";
			num = 0;
			sock = new Socket("172.16.88.205", 2011);
			out = new PrintStream(sock.getOutputStream());
			in = new BufferedReader(
					new InputStreamReader(sock.getInputStream()));
			out.println("register:" + name + ";");
			message = "";
			accum = 0;
			int x = in.read();

			while (message.indexOf("you win") == -1
					|| message.indexOf("game over") == -1
					|| message.indexOf("too many guesses") == -1) {
				sock = new Socket("172.16.88.205", 2011);
				out = new PrintStream(sock.getOutputStream());
				in = new BufferedReader(new InputStreamReader(
						sock.getInputStream()));
				out.println("guess:" + name + ":" + num + ";");
				numLow = 0;
				numHigh = 0;
				stringLow = "";
				stringHigh = "";
				message = "";
				accum = 0;
				x = in.read();
				while (x != 59) {
					message += (char) x;
					if (x == 58) {
						accum++;
					}
					if (accum == 2 && x != 58) {
						stringLow += (char) x;
					} else if (accum == 4 && x != 58) {
						stringHigh += (char) x;
					}
					x = in.read();
				}
				for (int i = stringLow.length() - 1; i >= 0; i--) {
					for (int digit = 0; digit <= 9; digit++) {
						if (stringLow.substring(i, i + 1).equals(digit)) {
							numLow += (digit * Math.pow(10,
									(stringLow.length() - (i + 1))));
						}
					}
					if (stringLow.substring(i, i + 1).equals("-")) {
						numLow = -numLow;
					}
				}
				for (int i = stringHigh.length() - 1; i >= 0; i--) {
					for (int digit = 0; digit <= 9; digit++) {
						if (stringHigh.substring(i, i + 1).equals(digit)) {
							numHigh += (digit * Math.pow(10,
									(stringHigh.length() - (i + 1))));
						}
					}
					if (stringLow.substring(i, i + 1).equals("-")) {
						numHigh = -numHigh;
					}
				}
				System.out.println(message);
				num = (numLow + numHigh) / 2;
			}

		} catch (UnknownHostException uhe) {
			System.out.println("Unknown Host");
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Throwable t) {

			}
			try {
				sock.close();
			} catch (Throwable t) {

			}
		}

	}
}
