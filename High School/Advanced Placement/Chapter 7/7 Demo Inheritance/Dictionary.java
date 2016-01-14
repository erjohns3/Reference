public class Dictionary extends Book {
	private String[] words;
	private String[] definitions;
	
	
	public Dictionary(String title, int p, String i, double pr) {
		super(title, p, i, pr); // sends the parameters to 
		                        // the Book's constructor
		
		words = new String[]{
				"Apple", "Cannibal", "Donkey", "Yellow"
		};
		
		definitions = new String[]{
			"A red fruit",
			"A species that eats its own kind",
			"A comical horse",
			"The color of a SmileyFace"
		};
		
	}
	
	public String getShelfLocation() {
		return "Reference Shelf";
	}
	
	public String lookup(String w) {
		
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(w)) {
				return definitions[i];
			}
		}
	
		return "I don't know that word";
			
	}
	
	public String toString() {
		return super.toString() + "\nWords: " + words.length;
	}
}
	
	
	
	
	


