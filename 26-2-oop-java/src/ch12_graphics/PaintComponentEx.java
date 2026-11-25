package ch12_graphics;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PaintComponentEx extends JFrame {
	private static final long serialVersionUID = 1L;

	public PaintComponentEx() {
		setTitle("새로운 버튼 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		MyButton b = new MyButton("New Button");
		b.setOpaque(true);
		b.setBackground(Color.CYAN);
		c.add(b);
		setSize(250, 200);
		setVisible(true);
	}

	class MyButton extends JButton {
		private static final long serialVersionUID = 1L;

		MyButton(String s) {
			super(s);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);
		}
	}

	public static void main(String[] args) {
		new PaintComponentEx();
	}
}
