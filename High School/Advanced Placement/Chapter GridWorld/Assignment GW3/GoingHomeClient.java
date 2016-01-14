import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.util.*;
import java.awt.*;
public class GoingHomeClient {
	public static void main(String[] args) {
		Grid<Actor> grid = new BoundedGrid<Actor>(19, 19);
		ActorWorld world = new ActorWorld(grid);
		for (int i = 0; i < 50; i++) {
			world.add(new Rock());
			world.add(new Flower());
		}
		for (int i = 0; i < 10; i++) {
			world.add(new GoingHomeCritter());
		}
		
		world.show();
		
	}
}