import info.gridworld.actor.*;
import info.gridworld.grid.*;

public class CritterClient {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(19,19));
		
		world.add(new Critter());
		world.add(new Critter());
		
		for (int i = 0; i < 20; i++) {
			world.add(new Bug());
			world.add(new Rock());
		}
		
		world.show();
	}

}
