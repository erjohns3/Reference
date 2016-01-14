import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JOptionPane;

public class Client {
	public static void main(String[] args) {
		Product p;
		BufferedReader inFile = null;
		HashMap<String, String> products = new HashMap<String, String>();
		try {
			inFile = new BufferedReader(new FileReader("SampleData.txt"));

			String line = inFile.readLine();
			while (line != null) {
				String[] parts = line.split(" - ");
				String[] prices = parts[1].split(" ");
				Product product = new Product(parts[0],
						Double.parseDouble(prices[0]), parts[2]);
				products.put(product.getID(), product.getPrice() + " Euros");
				line = inFile.readLine();
			}
		} catch (FileNotFoundException fne) {
			System.out.println(fne);
		} catch (IOException ioe) {
			System.out.println(ioe);
			ioe.printStackTrace();
		} finally {
			try {
				inFile.close();
			} catch (Exception ioe) {

			}
		}
		String key = JOptionPane.showInputDialog("Search Product ID");
		if (products.containsKey(key)){
			System.out.println(products.get(key));
		}

		else{
			System.out.println("Item not found");
		}
	}
}
