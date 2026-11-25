package ch10_event;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyListenerEx extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel[] keyMessage;

	public KeyListenerEx() {
		setTitle("keyListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.addKeyListener(new MyKeyListener());

		keyMessage = new JLabel[3];
		keyMessage[0] = new JLabel(" getKeyCode()");
		keyMessage[1] = new JLabel(" getKeyChar()");
		keyMessage[2] = new JLabel(" getKeyText()");

		for (int i = 0; i < keyMessage.length; i++) {
			c.add(keyMessage[i]);
			keyMessage[i].setOpaque(true);
			keyMessage[i].setBackground(Color.YELLOW);
		}

		setSize(300, 150);
		setVisible(true);

		c.setFocusable(true);
		c.requestFocus();
	}

	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			char keyChar = e.getKeyChar();

			keyMessage[0].setText(Integer.toString(keyCode));
			keyMessage[1].setText(Character.toString(keyChar));
			keyMessage[2].setText(KeyEvent.getKeyText(keyCode));

			if (keyChar == '%') {
				getContentPane().setBackground(Color.YELLOW);
			} else if (keyCode == KeyEvent.VK_F1 || keyCode == KeyEvent.VK_1) {
				getContentPane().setBackground(Color.GREEN);
			}
		}
	}

	public static void main(String[] args) {
		new KeyListenerEx();
	}
}
