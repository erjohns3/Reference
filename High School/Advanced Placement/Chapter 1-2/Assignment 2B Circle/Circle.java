//**********************************************************
//  Circle.java
//
//  Print the area of a circle with two different radii
//**********************************************************
import java.util.*;

public class Circle {
	public static void main(String[] args) {

		//****************************************************************************
		// This will calculate the area of a circle with a radius of 10
		//****************************************************************************
		final double PI = 3.14159;		// A constant for pi
		int radius = 10;
		double area = PI * radius * radius;
				
		System.out.println("The area of a circle with radius " + radius + " is " + area);

		//****************************************************************************
		// Now we're going to reuse the variables to calculate area for a radius of 20
		//****************************************************************************
		radius = 20;
		area = PI * radius * radius;
		
		System.out.println("The area of a circle with radius " + radius + " is " + area);
	
	}
}
