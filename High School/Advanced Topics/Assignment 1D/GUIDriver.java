import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GUIDriver extends JPanel implements ActionListener {

	/**************************************************************************/
	/* Class level variables - can be "seen" by all methods	                  */
	/**************************************************************************/
	private JButton btnOne;
	private JButton btnTwo;
	private JButton btnThree;
	private JButton btnFour;

	/***********************************************************************************/
	/* This method gets called automatically when the user clicks a registered JButton */
	/***********************************************************************************/
	public void actionPerformed(ActionEvent e) {
		Graphics g = getGraphics();		// local variable to hold the graphics to draw on

		if (e.getSource() == btnOne) 	{	// button 1 clicked
			
		}
		else if (e.getSource() == btnTwo)	{	// button 2 clicked

		}
		else if (e.getSource() == btnThree)	{	// button 3 clicked

		}
		else if (e.getSource() == btnFour)	{	// button 4 clicked

		}
	}

	/**************************************************************************/
	/* Set up GUI - gets called by the main method                            */
	/**************************************************************************/
	private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(false);				// give JFrame nice decorations
		JFrame frame = new JFrame("Java GUI");						// create the JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// set up the JFrame to end the program when it closes
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());

		GUIDriver panel = new GUIDriver();						// set up the panel to draw in
		panel.setBackground(Color.BLACK);					// the the background to black

		panel.btnOne = new JButton("Button 1");							// instantiate a swing button
		panel.btnOne.addActionListener(panel);					// register the panel with the button
		panel.btnTwo = new JButton("Button 2");							// instantiate a swing button
		panel.btnTwo.addActionListener(panel);					// register the panel with the button
		panel.btnThree = new JButton("Button 3");
		panel.btnThree.addActionListener(panel);
		panel.btnFour = new JButton("Button 4");							// instantiate a swing button
		panel.btnFour.addActionListener(panel);					// register the panel with the button

		Panel buttonPanel = new Panel();							// instantiate the panel for buttons
		buttonPanel.add(panel.btnOne);									// add the swing button the the button panel
		buttonPanel.add(panel.btnTwo);
		buttonPanel.add(panel.btnThree);
		buttonPanel.add(panel.btnFour);

		c.add(panel,BorderLayout.CENTER);					// add the drawing panel to the frame (take up the entire frame)
		c.add(buttonPanel,BorderLayout.SOUTH);						// add the button panel to the bottom of the frame

        //panel.setOpaque(true); 											// content panes must be opaque
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
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
