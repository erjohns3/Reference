import javax.swing.*;
import java.awt.*;

public class DemoFlowLayout {

	public static void main(String[] args) {
		JFrame ben = new JFrame("I'm a GUI");
		
		ben.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ben.setSize(500, 600);
		ben.setLayout(new FlowLayout());
		
		JButton conrad = new JButton("I'm a Button");
		ben.add(conrad);
		
		JTextField deez = new JTextField(10);
		ben.add(deez);
		
		JLabel lbl = new JLabel("I'm a label");
		ben.add(lbl);
		
		JCheckBox ballin = new JCheckBox("I'm a checkbox");
		ben.add(ballin);
		
		JRadioButton codine = new JRadioButton("Low");
		ben.add(codine);
		JRadioButton codine1 = new JRadioButton("Medium");
		ben.add(codine1);
		JRadioButton codine2 = new JRadioButton("High");
		ben.add(codine2);
		
		ButtonGroup group = new ButtonGroup();
		group.add(codine);
		group.add(codine1);
		group.add(codine2);
		
		JTextArea malone = new JTextArea(20, 10);
		JScrollPane sp = new JScrollPane(malone);
		malone.setLineWrap(true);
		ben.add(sp);
		
		JComboBox spring = new JComboBox();
		spring.addItem("Pizza");
		spring.addItem("Ice Cream");
		spring.addItem("Fries");
		spring.addItem("Styrafoam");
		ben.add(spring);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		ben.setVisible(true);
	
	}

}
