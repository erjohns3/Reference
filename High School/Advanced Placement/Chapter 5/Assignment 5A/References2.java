// *********************************************************************
//   References2.java
//
//   Illustrates references versus primitive variables
// *********************************************************************

public class References2 {
   public static void main (String[] args) {
      int age1, age2, age3;

      age1 = 10;
      age2 = 20;
      age3 = 30;
 
      // Instantiate three Person objects with the ages read in
      Person person1 = new Person ("Rachel", 10);
      Person person2 = new Person ("Elly", 20);
      Person person3 = new Person ("Sarah", 30);

      System.out.println();
      System.out.println ("The original three people...");
      System.out.println (person1 + ", " + person2 + ", " + person3);
 
      // Reassign some primitive variables 
      age1 = age2;
      age3 = age2;

      // Reassign some object variables
      person1 = person2;
      person3 = person2;

      // Make some other changes (including calling a mutator method)
      age2 = 99;
      person2.changeAge(99);  

	  // Make some other changes
	  age1 = 100;
      person1.changeAge(100);
 
      System.out.println ("The changed values are...");
      System.out.println ("Ages (ints): " + age1 + ", " + age2 + ", " + age3);
      System.out.println (person1 + ", " + person2 + ", " + person3);
      
   }
}
