import info.gridworld.grid.*;
import info.gridworld.actor.*;

public class Client {

	public static void main(String[] args) {
		
		Location loc1 = new Location(3,4);
		System.out.println(loc1.NORTHWEST);	// a constant variable
		System.out.println(loc1.RIGHT);		// a constant variable
		
		System.out.println(loc1.getAdjacentLocation(Location.NORTH));
		System.out.println(loc1.getAdjacentLocation(Location.NORTHEAST));
		
		System.out.println(loc1.getDirectionToward(new Location(0,1000000)));
		
		Location loc2 = new Location(3,4);
		
		System.out.println(loc1.equals(loc2));
		System.out.println(loc1.compareTo(loc2));
		System.out.println(loc1);

		Grid<Actor> grid = new BoundedGrid<Actor>(25,25);
		System.out.println(grid.isValid(new Location(15,15)));
		System.out.println(grid.isValid(new Location(25,5)));
		
		grid.put(new Location(1,1), new Actor());
		System.out.println(grid.get(new Location(1,1)));
		System.out.println(grid.get(loc1));
		
		System.out.println(grid.getValidAdjacentLocations(new Location(0,0)));
		System.out.println(grid.getValidAdjacentLocations(loc1));
		
		
		
		
		
		
		
	}

}
