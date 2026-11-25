package ch11_component;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboActionEx extends JFrame {
	private static final long serialVersionUID = 1L;

	private String[] fruits = {"apple", "banana", "kiwi", "mango"};
	private ImageIcon[] images = {new ImageIcon("images/apple.jpg"), new ImageIcon("images/banana.jpg"),
			new ImageIcon("images/kiwi.jpg"), new ImageIcon("images/mango.jpg")};
	private JComboBox<String> strCombo = new JComboBox<String>(fruits);
	private int[] prices = {100, 200, 300, 400};
	private JLabel imgLabel = new JLabel(images[0]);
	private JLabel priceLabel = new JLabel(fruits[0] + " " + prices[0] + "원");

	private JCheckBox checkBox = new JCheckBox("구매");

	public ComboActionEx() {
		setTitle("콤보박스 활용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(strCombo);
		c.add(imgLabel);
		c.add(priceLabel);
		c.add(checkBox);

		strCombo.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				int index = cb.getSelectedIndex();
				imgLabel.setIcon(images[index]);
				priceLabel.setText(fruits[index] + " " + prices[index] + "원");
			}
		});
		setSize(300, 250);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ComboActionEx();
	}
}