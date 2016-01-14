// *********************************************************************
//   References1.java
//
//   Illustrates aliases and references
// *********************************************************************


public class References1 {
    public static void main (String[] args) {

		Person person1 = new Person ("Rachel", 6);
		Person person2 = new Person ("Elly", 4);
		Person person3 = new Person ("Sarah", 19);

		System.out.println ("\nThe original three people...");
		System.out.println (person1 + ", " + person2 + ", " + person3);

		// Reassign people
		person1 = person2;
		person2 = person3;
		person3 = person1;

		// Call mutator methods on the people
		person2.changeName ("Bozo");
		person3.changeName ("Clarabelle");
		person1.changeName("Harpo");

		System.out.println ("\nThe final three people...");
		System.out.println (person1 + ", " + person2 + ", " + person3);
    }
}
