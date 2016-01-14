import java.awt.*;
import javax.swing.*;
import java.util.*;

public class SmileyFaceClient extends JPanel {
	Graphics g;
	
	public void display() {			
		/******************************************************/
		/* Your code goes here                                */
		/******************************************************/
	
	
	
	}

	public static void main(String[] args) {			// runs when the program starts
		JFrame.setDefaultLookAndFeelDecorated(true);					// give JFrame nice decorations
		JFrame frame = new JFrame("SmileyFaceClient");			// create the JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// set up the JFrame to end when user clicks X
		SmileyFaceClient panel = new SmileyFaceClient();			// make a new EmptyShell JFrame
		panel.setOpaque(true);
		panel.setBackground(Color.BLACK);
		frame.setContentPane(panel);

		GraphicsConfiguration gc = frame.getGraphicsConfiguration();
		int width=(int)(gc.getBounds().getWidth());
		int height=(int)(gc.getBounds().getHeight()-30);
		frame.setSize(width, height);
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