import javax.swing.*;
import java.awt.*;

public class ScalableShapes extends JPanel {
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLUE);		// set the drawing color
		
	}

    private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);					// give JFrame nice decorations
        JFrame frame = new JFrame("Scalable");			// create the JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// set up the JFrame to end when user clicks X
        ScalableShapes panel = new ScalableShapes();	// set up the content pane

		// Your code for setting up the GUI GUI goes here
		frame.setBackground(Color.BLACK);
        frame.setContentPane(panel);										// add the panel to the JFrame
        panel.setOpaque(false); 												// content panes must be opaque
		frame.setSize(800,600);        

        //frame.pack();													// optional - will cause the frame to be the minimum size necessary
        frame.setVisible(true);											// display the JFrame
	}
	
	public static void main(String[] args) {							// called when the program starts
		javax.swing.SwingUtilities.invokeLater(new Runnable() {			// schedule a job for the event-dispatching thread;
			public void run() {
				createAndShowGUI(); 
			}
		});
	}
	
}
