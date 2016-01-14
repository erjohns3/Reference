import java.awt.*;
import javax.swing.*;
import java.util.*;

public class SmileyFaceClient extends JPanel {
	Graphics g;
	
	public void display() {			
		SmileyFace s = new SmileyFace(100,100,100,this);
		s.setColor(Color.RED);
	}

	public static void main(String[] args) {			// runs when the program starts
		JFrame.setDefaultLookAndFeelDecorated(true);					// give JFrame nice decorations
		JFrame frame = new JFrame("SmileyFaceClient");			// create the JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// set up the JFrame to end when user clicks X
		SmileyFaceClient panel = new SmileyFaceClient();			// make a new EmptyShell JFrame
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