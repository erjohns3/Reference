import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class JavaGUI extends JPanel implements ActionListener {

	/**************************************************************************/
	/* Class level variables - can be "seen" by all methods	                  */
	/**************************************************************************/
	private JButton btnDrawOne;
	private JButton btnDrawFive;
	private JButton btnDrawMany;
	private JButton btnClear;
	private Graphics g;

	/***********************************************************************************/
	/* This method gets called automatically when the user clicks a registered JButton */
	/***********************************************************************************/
	public void actionPerformed(ActionEvent e) {
		g = getGraphics();
		
		if (e.getSource() == btnDrawOne) 	{	// "one" button clicked
			// draw on the screen
			int x = (int)(Math.random()*getWidth())-10;
			int y = (int)(Math.random()*getHeight())-10;
			Color c = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
			g.setColor(c);
			g.fillOval(x, y, 20, 20);
		}
		else if (e.getSource() == btnDrawFive) 	{	// "five" button clicked
			for (int i = 0; i < 5; i++) {
				// draw on the screen
				int x = (int)(Math.random()*getWidth())-10;
				int y = (int)(Math.random()*getHeight())-10;
				Color c = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
				g.setColor(c);
				g.fillOval(x, y, 20, 20);
			}
		}
		else if (e.getSource() == btnDrawMany) 	{	// "five" button clicked
			// to be done
		}
		else if (e.getSource() == btnClear)	{	// clear button clicked
			// clear the screen
			Color c = getBackground();				// set c equal to the background color
			g.setColor(c);						// set the drawing color to c
			g.fillRect(0, 0, getWidth(), getHeight());			// fill the rectangle (in the background color
		}
	}

	
	
	
	/**************************************************************************/
	/* Set up GUI - gets called by the main method                            */
	/**************************************************************************/
	private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);				// give JFrame nice decorations
		JFrame frame = new JFrame("Java GUI");						// create the JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// set up the JFrame to end the program when it closes
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());

		JavaGUI drawingPanel = new JavaGUI();						// set up the panel to draw in
		drawingPanel.setBackground(Color.BLACK);					// the the background to black

		drawingPanel.btnDrawOne = new JButton("One");							// instantiate a swing button
		drawingPanel.btnDrawOne.addActionListener(drawingPanel);					// register the panel with the button
		drawingPanel.btnDrawFive = new JButton("Five");							// instantiate a swing button
		drawingPanel.btnDrawFive.addActionListener(drawingPanel);					// register the panel with the button
		drawingPanel.btnDrawMany = new JButton("Many");							// instantiate a swing button
		drawingPanel.btnDrawMany.addActionListener(drawingPanel);					// register the panel with the button
		drawingPanel.btnClear = new JButton("Clear Screen");
		drawingPanel.btnClear.addActionListener(drawingPanel);

		Panel buttonPanel = new Panel();							// instantiate the panel for buttons
		buttonPanel.add(drawingPanel.btnDrawOne);									// add the swing button the the button panel
		buttonPanel.add(drawingPanel.btnDrawFive);									// add the swing button the the button panel
		buttonPanel.add(drawingPanel.btnDrawMany);									// add the swing button the the button panel
		buttonPanel.add(drawingPanel.btnClear);

		c.add(drawingPanel,BorderLayout.CENTER);					// add the drawing panel to the frame (take up the entire frame)
		c.add(buttonPanel,BorderLayout.SOUTH);						// add the button panel to the bottom of the frame

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);				// set the window to maximized
		frame.setSize(600, 400);									// set the frame size (in case user un-maximizes
		frame.setVisible(true);										// display the frame
	}
	
	/**************************************************************************/
	/* Main method - runs automatically when program starts                   */
	/**************************************************************************/
	public static void main(String[] args) {							// called when the program starts
		javax.swing.SwingUtilities.invokeLater(new Runnable() {			// Start the createAndShowGUI method in a separate thread
			public void run() {
				createAndShowGUI(); 
			}
		});
	}
	
}
