public class PersonClient {
	public static void main(String[] args) {

		Person p1 = new Person("Jim", 17);
		Person p2 = new Person("Jose", 14);
		Person p3 = new Person("Raven", 15);

		System.out.println(p1 + "\n" + p2 + "\n" + p3);

		System.out.println(p1.getNumberOfPeople());
		System.out.println(p2.getNumberOfPeople());
		System.out.println(p3.getNumberOfPeople());
		System.out.println(Person.getNumberOfPeople());
		
		Person p4 = new Person("Howdy Doody", 13);
		System.out.println(Person.getNumberOfPeople());
		
		System.out.println(Math.sqrt(7));
	}
}
