import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.util.*;
import java.awt.*;
public class BugClient  {
	public static void main(String[] args) {
		Grid<Actor> grid = new BoundedGrid<Actor>(19, 19);
		ActorWorld world = new ActorWorld(grid);
		Bug b = new Bug();
		b.setDirection((int)(Math.random()*8)*45);	// random degrees - 45 degree increments
		world.add(b);
		/*******************************************************/
		/* DO NOT CHANGE CODE ABOVE THIS MARKER                */
		/*******************************************************/
		
		
		/*******************************************************/
		/* DO NOT CHANGE CODE BELOW THIS MARKER                */
		/*******************************************************/
		world.show();
		
	}
}