package ch09_gui;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class NullContainerEx extends JFrame {
	private static final long serialVersionUID = 1L;

	public NullContainerEx() {
		setTitle("Null Container Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);

		JLabel la = new JLabel("Hello, Press Buttons!");
		la.setLocation(130, 50);
		la.setSize(200, 20);
		c.add(la);

		// for(int i = 0;;)
	}
}
