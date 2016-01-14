public class Product {
	private String id;
	private double price;
	private String description;

	public Product(String i, double p, String d) {
		id = i;
		price = p;
		description = d;
	}

	public String getID() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public void setPrice(double p2) {
		price = p2;
	}

	public void setDescription(String d2) {
		description = d2;
	}
}
