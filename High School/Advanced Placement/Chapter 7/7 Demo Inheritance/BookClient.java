public class BookClient {

	public static void main(String[] args) {
		// Book is abstract, we can't make 'em
		//Book b1 = new Book("Of Mice and Men", 187, "0-14-118510-4" , 9.63);
		//b1.nextPage();
		//b1.nextPage();
		//System.out.println(b1.getCurrentPage());
		
		Dictionary b2 = new Dictionary("Webster's Dictionary",
					1257, "23-2324323-0", 25.37);
		
		b2.nextPage();
		b2.nextPage();
		System.out.println(b2.getCurrentPage());
	
		System.out.println(b2.lookup("Donkey"));
		System.out.println(b2.lookup("Car"));
		System.out.println(b2.toString());
		
		
		
		
	}

}
