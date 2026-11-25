package report;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Report7 extends JFrame {
	private static final long serialVersionUID = 1L;

	private static final int MAX_LINES = 10; // 사람 그림의 직선 개수

	// 그림이 차지하는 영역 (HangmanEx 좌표: 가로 50~160, 세로 60~170)
	private static final int FIGURE_RIGHT = 160; // 그림 오른쪽 끝
	private static final int FIGURE_TOP = 60; // 그림 위쪽 끝
	private static final int FIGURE_HEIGHT = 110; // 그림 높이 (60~170)
	private static final int GAP = 40; // 그림과 글자, 버튼 사이 간격

	// 글자와 버튼 크기
	private static final int DELETE_WIDTH = 80; // 삭제 버튼 폭
	private static final int RESET_WIDTH = 90; // 초기화 버튼 폭
	private static final int BUTTON_HEIGHT = 30; // 버튼 높이
	private static final int BUTTON_GAP = 10; // 두 버튼 사이 간격
	private static final int LABEL_HEIGHT = 30; // 글자 높이
	private static final int ROW_GAP = 20; // 글자와 버튼 사이 간격

	// 글자와 버튼 묶음 크기 (위 값들로 계산)
	private static final int BLOCK_WIDTH = DELETE_WIDTH + BUTTON_GAP + RESET_WIDTH;
	private static final int BLOCK_HEIGHT = LABEL_HEIGHT + ROW_GAP + BUTTON_HEIGHT;

	private int lineCount = MAX_LINES; // 남은 직선 개수

	private JButton deleteButton = new JButton("삭제");
	private JButton resetButton = new JButton("초기화");
	private JLabel countLabel = new JLabel(); // 남은 직선 개수
	private JPanel drawingPanel = new DrawingPanel(); // 그림, 글자, 버튼 패널

	public Report7() {
		setTitle("Report7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(420, 260);

		drawingPanel.setLayout(null); // 배치관리자 없이 위치를 직접 정함
		drawingPanel.setBackground(Color.white);

		int blockLeft = FIGURE_RIGHT + GAP;
		int blockTop = FIGURE_TOP + (FIGURE_HEIGHT - BLOCK_HEIGHT) / 2;
		int buttonTop = blockTop + LABEL_HEIGHT + ROW_GAP;

		countLabel.setFont(new Font("Arial", Font.BOLD, 24));
		countLabel.setForeground(Color.RED);
		countLabel.setHorizontalAlignment(SwingConstants.CENTER);
		countLabel.setBounds(blockLeft, blockTop, BLOCK_WIDTH, LABEL_HEIGHT);

		deleteButton.setBackground(Color.orange);
		deleteButton.setBounds(blockLeft, buttonTop, DELETE_WIDTH, BUTTON_HEIGHT);
		resetButton.setBounds(blockLeft + DELETE_WIDTH + BUTTON_GAP, buttonTop, RESET_WIDTH, BUTTON_HEIGHT);

		// 삭제 버튼 리스너
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteLine();
			}
		});

		// 초기화 버튼 리스너
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineCount = MAX_LINES; // 직선 10개 다시 그림
				updateDisplay();
			}
		});

		drawingPanel.add(countLabel);
		drawingPanel.add(deleteButton);
		drawingPanel.add(resetButton);

		Container contentPane = getContentPane();
		contentPane.add(drawingPanel);

		updateDisplay();

		setVisible(true);
	}

	private void deleteLine() {
		if (lineCount > 0) {
			lineCount--;
		}

		updateDisplay();
	}

	// 글자, 버튼, 그림을 지금 lineCount에 맞게 바꿈
	private void updateDisplay() {
		countLabel.setText(lineCount + " lines left");

		if (lineCount <= 0) {
			deleteButton.setEnabled(false);
		} else {
			deleteButton.setEnabled(true);
		}

		repaint();
	}

	public static void main(String[] args) {
		new Report7();
	}

	// 사람 그림을 그리는 패널
	class DrawingPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			super.paintComponent(g); // 배경을 먼저 지움
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.BLACK);

			g2.drawOval(60, 80, 20, 20); // 얼굴 (원은 지워지지 않음)

			// fall-through
			switch (lineCount) {
			case 10:
				g2.drawLine(70, 130, 85, 150); // 오른 다리
			case 9:
				g2.drawLine(70, 130, 55, 150); // 왼 다리
			case 8:
				g2.drawLine(70, 110, 90, 110); // 오른팔
			case 7:
				g2.drawLine(50, 110, 70, 110); // 왼팔
			case 6:
				g2.drawLine(70, 110, 70, 130); // 몸통 아래
			case 5:
				g2.drawLine(70, 100, 70, 110); // 몸통 위
			case 4:
				g2.drawLine(70, 60, 70, 80); // 밧줄
			case 3:
				g2.drawLine(70, 60, 130, 60); // 윗막대
			case 2:
				g2.drawLine(130, 60, 130, 170); // 기둥
			case 1:
				g2.drawLine(60, 170, 160, 170); // 받침대
			}
		}
	}
}
