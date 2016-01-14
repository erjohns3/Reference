import javax.swing.*;
import java.awt.*;

public class DemoBorderLayout {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Demo Border Layout");
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//let it default to BorderLayout
		//frame.setLayout(new FlowLayout());
		
		//You can add only five things to a BorderLayout
		//North, East, South, West, Center
		
		JTextField txt = new JTextField(10);
		frame.add(txt, BorderLayout.NORTH);
		
		JCheckBox chk = new JCheckBox("Graduated?");
		frame.add(chk, BorderLayout.SOUTH);
		
		JLabel lbl = new JLabel("I'm a label");
		frame.add(lbl, BorderLayout.EAST);
		
		JButton butt = new JButton("Press Me!");
		frame.add(butt, BorderLayout.CENTER);
		
		JPanel panel = new JPanel(); 	// defaults to flow layout
		JRadioButton rb1 = new JRadioButton("Female");
		JRadioButton rb2 = new JRadioButton("Male");
		panel.add(rb1);
		panel.add(rb2);
		
		
		frame.add(panel, BorderLayout.WEST);
		
		
		
		
		
		
		frame.setVisible(true);
	}

}
