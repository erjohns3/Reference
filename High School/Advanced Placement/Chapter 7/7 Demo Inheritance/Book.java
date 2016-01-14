public abstract class Book {	// if a class has an abstract method
								// the class must be abstract
	private int pages;
	private int currentPage;
	private String isbn;
	private double price;
	private String title;
	
	public Book(String title, int p, String i, double pr) {
		this.title = title;
		pages = p;
		currentPage = 0;
		isbn = i;
		price = pr;
	}
	
	// abstract method: a method header, but no body
	public abstract String getShelfLocation(); 
	
	public void nextPage() {
		if (currentPage < pages) 
			currentPage++;
	}
	
	public void prevPage() {
		if (currentPage > 0)
			currentPage--;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	
	public String toString() {
		return title + "\n" + isbn + "\nPrice: " + price + 
			"\nPages: " + pages;
	
	}
}