import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.util.*;
import java.awt.*;
public class ChameleonClient  {
	public static void main(String[] args) {
		Color[] colors = {Color.RED, Color.GREEN, Color.YELLOW, Color.BLACK, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK};

		Grid<Actor> grid = new BoundedGrid<Actor>(19, 19);
		ActorWorld world = new ActorWorld(grid);
		
		for (int i = 0; i < 10; i++) {
			world.add(new Rock(colors[(int)(Math.random()*colors.length)]));
			world.add(new Flower(colors[(int)(Math.random()*colors.length)]));
			world.add(new BoxBug(0, colors[(int)(Math.random()*colors.length)]));
		}

		world.add(new ChameleonCritter());
		
		world.show();
		
	}
}