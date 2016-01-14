import java.awt.*;
import javax.swing.*;
import java.util.*;

public class SmileyClient extends JPanel {
	Graphics g;
	
	public void display() {			
		SmileyFace s = new SmileyFace(200, 300, 10, this);
		SmileyFace s1 = new SmileyFace(600,300, 10, this);
		Random r = new Random();
		int g1 = r.nextInt(20)+1;
		int g2 = r.nextInt(20)+1;
		s.grow(g1);
		s1.grow(g2);
		if (s.getArea()<s1.getArea()) {
			s.frown();
			s1.smile();
		}
		else {
			s.smile();
			s1.frown();
		}

	}

	public static void main(String[] args) {			// runs when the program starts
		JFrame.setDefaultLookAndFeelDecorated(true);					// give JFrame nice decorations
		JFrame frame = new JFrame("SmileyClient");			// create the JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// set up the JFrame to end when user clicks X
		SmileyClient panel = new SmileyClient();			// make a new EmptyShell JFrame
		panel.setOpaque(true);
		panel.setBackground(Color.BLACK);
		frame.setContentPane(panel);
		frame.setSize(800,600);							// set the size of the JFrame
		frame.setVisible(true);							// show the JFame
		try {
			Thread.sleep(500);
		}
		catch (InterruptedException e) {
		}
		panel.g = panel.getGraphics();
		panel.display();									// call the driver() method
	}
}