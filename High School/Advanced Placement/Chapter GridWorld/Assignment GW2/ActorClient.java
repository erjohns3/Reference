import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.util.*;
import java.awt.*;
public class ActorClient  {
	public static void main(String[] args) {
		Grid<Actor> grid = new BoundedGrid<Actor>(19, 19);
		ActorWorld world = new ActorWorld(grid);
		for (int i = 0; i < 15; i++) {
			world.add(new Actor());
			world.add(new Bug());
			world.add(new Critter());
		}
		/*******************************************************/
		/* DO NOT CHANGE CODE ABOVE THIS MARKER                */
		/*******************************************************/

		
		
		/*******************************************************/
		/* DO NOT CHANGE CODE BELOW THIS MARKER                */
		/*******************************************************/
		world.show();
		
	}
}