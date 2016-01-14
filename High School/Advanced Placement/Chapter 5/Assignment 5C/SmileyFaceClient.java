import java.awt.*;
import javax.swing.*;
import java.util.*;

public class SmileyFaceClient extends JPanel {
	Graphics g;
	
	public void display() {			
		int x = 75;
		SmileyFace s1 = new SmileyFace(x, 100, 30, this);
		SmileyFace s2 = new SmileyFace(x+=70, 100, 30, this);
		SmileyFace s3 = new SmileyFace(x+=70, 100, 30, this);
		SmileyFace s4 = new SmileyFace(x+=70, 100, 30, this);
		SmileyFace s5 = new SmileyFace(x+=70, 100, 30, this);
		SmileyFace s6 = new SmileyFace(x+=70, 100, 30, Color.RED, this);
		SmileyFace s7 = new SmileyFace(x+=70, 100, 30, this);
		SmileyFace s8 = new SmileyFace(x+=70, 100, 30, this);
		SmileyFace s9 = new SmileyFace(x+=70, 100, 30, this);
		SmileyFace s10 = new SmileyFace(x+=70, 100, 30, this);

		s1.frown();
		s1.frown();
		s1.smile();
		s1.smile();
		s7.frown();
		s9.frown();

		/*****************************************************************************************/
		/* Don't change stuff above this line                                                    */
		/*****************************************************************************************/
	
	
	
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