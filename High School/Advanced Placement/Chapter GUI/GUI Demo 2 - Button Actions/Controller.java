import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// step 1: write a class that implements ActionListener
public class Controller implements ActionListener {
	private SimpleGUI gui;
	
	public Controller() {
		gui = new SimpleGUI(this);
	}
	
	// step 2: write the actionPerformed() method
	// This runs when the button is pressed
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Change Label")) {
			gui.changeLabel("Your mom's a poop");		}
		else if (e.getActionCommand().equals("Change Background")) {
			gui.changeBackground(new Color((int)(Math.random()*256), 
					(int)(Math.random()*256),
					(int)(Math.random()*256)));
		}
	
	}
	
	
}
