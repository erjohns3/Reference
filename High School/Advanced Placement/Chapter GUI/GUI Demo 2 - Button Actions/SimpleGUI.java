import java.awt.*;
import javax.swing.*;

public class SimpleGUI {
	private JLabel lbl;
	private JFrame f;

	public SimpleGUI(Controller c) {
		f = new JFrame("A Simple GUI");
		f.setSize(800, 550);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout());
		
		JButton b1 = new JButton("Change Label");
		JButton b2 = new JButton("Change Background");
		lbl = new JLabel("I'm a label");

		// step 3: register the ActionListener with each button
		b1.addActionListener(c);
		b2.addActionListener(c);

		
		
		f.add(b1);
		f.add(b2);
		f.add(lbl);
		
		f.setVisible(true);
	}
	
	public void changeLabel(String s) {
		lbl.setText(s);
	}

	public void changeBackground(Color c) {
		f.getContentPane().setBackground(c);
	}

}