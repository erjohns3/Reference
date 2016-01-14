import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorBars extends JPanel implements ActionListener {

	/**************************************************************************/
	/* Instance Variables - can be "seen" by all methods	                  */
	/**************************************************************************/
	private JButton btnDraw;
	private JButton btnClear;

	/***********************************************************************************/
	/* This method gets called automatically (and asynchronously, when the user clicks */
	/* a registered JButton                                                            */
	/***********************************************************************************/
	public void actionPerformed(ActionEvent e) {
		Graphics g = getGraphics();		// local variable to hold the graphics to draw on
		Color c;						// local variable to hold a color

		if (e.getSource() == btnDraw) 	{	// draw button clicked
			// draw on the screen
			c = new Color(150, 0, 0);			// instantiate a new color and store it in c
			g.setColor(c);						// set the drawing color c
			g.fillRect(20, 20, 20, 20);			// fill a rectangle on the screen
		}
		else if (e.getSource() == btnClear)	{	// clear button clicked
			// clear the screen
			c = getBackground();				// set c equal to the background color
			g.setColor(c);						// set the drawing color to c
			g.fillRect(20, 20, 20, 20);			// fill the rectangle (in the background color
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

		ColorBars drawingPanel = new ColorBars();						// set up the panel to draw in
		drawingPanel.setBackground(Color.BLACK);					// the the background to black

		drawingPanel.btnDraw = new JButton("Click me");				// instantiate a swing button
		drawingPanel.btnDraw.addActionListener(drawingPanel);		// register the panel with the button
		drawingPanel.btnClear = new JButton("Clear Screen");
		drawingPanel.btnClear.addActionListener(drawingPanel);

		Panel buttonPanel = new Panel();							// instantiate the panel for buttons
		buttonPanel.add(drawingPanel.btnDraw);						// add the swing button the the button panel
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
