package report;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// 계산기 화면
public class Report6 extends JFrame {
	private static final long serialVersionUID = 1L;

	// 버튼 글자
	private String[] buttonNames = { "⌫", "(", ")", "÷", "7", "8", "9", "×", "4", "5", "6", "-", "1", "2", "3", "+",
			"AC", "0", ".", "=" };

	private PostfixCalculator calculator = new PostfixCalculator();
	private JLabel formulaLabel = new JLabel(" "); // 위쪽 작은 글씨: 계산하기 전 수식
	private JLabel display = new JLabel("0"); // 아래쪽 큰 글씨: 입력 중인 수식, 결과
	private boolean justCalculated = false; // 방금 = 눌러서 결과가 떠 있는 상태인지

	public Report6() {
		setTitle("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel c = (JPanel) getContentPane();
		c.setLayout(new BorderLayout(0, 10)); // 결과 화면과 버튼판 사이 10
		c.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 바깥 테두리 여백
		c.add(createDisplay(), BorderLayout.NORTH);
		c.add(createButtonPanel(), BorderLayout.CENTER);
		c.addKeyListener(new MyKeyListener());

		setSize(320, 400);
		setVisible(true);

		c.setFocusable(true); // 키 입력을 받으려면 포커스가 있어야 함
		c.requestFocus();
	}

	// 위쪽 결과 화면
	private JPanel createDisplay() {
		formulaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		formulaLabel.setFont(new Font("Helvetica Neue Light", Font.PLAIN, 16));
		formulaLabel.setForeground(Color.GRAY);

		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setFont(new Font("Helvetica Neue Light", Font.PLAIN, 36));

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(formulaLabel, BorderLayout.NORTH);
		panel.add(display, BorderLayout.CENTER);
		return panel;
	}

	// 가운데 버튼판
	private JPanel createButtonPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 4, 5, 5));

		MyActionListener listener = new MyActionListener();
		for (String name : buttonNames) {
			JButton btn = new JButton(name);
			btn.addActionListener(listener);
			btn.setFocusable(false); // 버튼을 눌러도 키보드 포커스를 뺏기지 않게
			panel.add(btn);
		}
		return panel;
	}

	// 누른 버튼 글자 보고 처리 메서드 호출
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			String input = b.getText();

			switch (input) {
			case "AC" -> clear();
			case "⌫" -> backspace();
			case "(" -> openParen();
			case ")" -> closeParen();
			case "=" -> calculate();
			default -> append(input); // 숫자, 연산자, 점
			}
		}
	}

	// 키보드 입력도 버튼과 같은 메서드로 처리
	private class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_ENTER) {
				calculate();
			} else if (keyCode == KeyEvent.VK_BACK_SPACE) {
				backspace();
			} else if (keyCode == KeyEvent.VK_ESCAPE) {
				clear(); // Esc = AC
			} else {
				typeKey(toKeyChar(e));
			}
		}
	}

	// 글자 키 처리 (계산기에서 안 쓰는 키는 무시)
	private void typeKey(char key) {
		switch (key) {
		case '=' -> calculate();
		case '(' -> openParen();
		case ')' -> closeParen();
		case '*' -> append("×");
		case '/' -> append("÷");
		case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', '+', '-' -> append(Character.toString(key));
		}
	}

	// 누른 키를 계산기 글자로 바꾸기
	// 한글 입력 상태에서는 getKeyChar()가 ( ) + 등을 못 돌려줄 수 있어서 키 코드와 Shift 로 한 번 더 확인
	private char toKeyChar(KeyEvent e) {
		char key = e.getKeyChar();
		if ("0123456789.+-*/=()".indexOf(key) >= 0) {
			return key;
		}

		int code = e.getKeyCode();
		if (e.isShiftDown()) {
			return switch (code) {
			case KeyEvent.VK_9 -> '(';
			case KeyEvent.VK_0 -> ')';
			case KeyEvent.VK_8 -> '*';
			case KeyEvent.VK_EQUALS -> '+';
			default -> 0;
			};
		}
		if (code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9) {
			return (char) ('0' + (code - KeyEvent.VK_0));
		}
		return switch (code) {
		case KeyEvent.VK_EQUALS -> '=';
		case KeyEvent.VK_MINUS -> '-';
		case KeyEvent.VK_SLASH -> '/';
		case KeyEvent.VK_PERIOD -> '.';
		default -> 0; // 계산기에서 안 쓰는 키
		};
	}

	// AC: 처음 상태로
	private void clear() {
		setFormula(" ");
		setDisplay("0");
		justCalculated = false;
	}

	// ⌫: 맨 끝 글자 하나 지우기
	private void backspace() {
		justCalculated = false;
		String formula = display.getText();
		if (formula.equals("Undefined") || formula.length() == 1) {
			setDisplay("0");
			return;
		}
		setDisplay(formula.substring(0, formula.length() - 1));
	}

	// (: 괄호 열기
	private void openParen() {
		String formula = display.getText();
		if (formula.equals("Undefined") || justCalculated) {
			formula = "0";
		}
		justCalculated = false;

		char last = formula.charAt(formula.length() - 1);
		if (formula.equals("0")) {
			setDisplay("(");
		} else if (isDigit(last) || last == '.' || last == ')') {
			setDisplay(formula + "×("); // 2( -> 2×(
		} else {
			setDisplay(formula + "(");
		}
	}

	// ): 열린 괄호가 있고 앞이 숫자나 ) 일 때만 닫기
	private void closeParen() {
		String formula = display.getText();
		if (formula.equals("Undefined") || justCalculated) {
			return;
		}

		char last = formula.charAt(formula.length() - 1);
		if (countOpen(formula) > 0 && (isDigit(last) || last == '.' || last == ')')) {
			setDisplay(formula + ")");
		}
	}

	// 아직 안 닫힌 괄호 개수
	private int countOpen(String formula) {
		int count = 0;
		for (int i = 0; i < formula.length(); i++) {
			if (formula.charAt(i) == '(') {
				count++;
			} else if (formula.charAt(i) == ')') {
				count--;
			}
		}
		return count;
	}

	// =: 계산 객체에 수식을 넘기고 결과 표시
	private void calculate() {
		String formula = display.getText();
		for (int i = countOpen(formula); i > 0; i--) {
			formula = formula + ")"; // 안 닫힌 괄호 자동으로 닫기
		}
		try {
			double result = calculator.calculate(formula);
			setFormula(formula + " ="); // 위쪽에 계산 전 수식
			setDisplay(toResultText(result)); // 아래쪽에 결과
			justCalculated = true;
		} catch (NullPointerException e) {
			return; // 3+ 처럼 덜 끝난 수식이면 아무 일도 안 함
		} catch (NumberFormatException e) {
			return; // . 처럼 숫자가 아닌 숫자
		}
	}

	// 아래쪽 큰 글씨 바꾸기
	private void setDisplay(String text) {
		display.setText(text);
		fitFont(display, 36);
	}

	// 위쪽 작은 글씨 바꾸기
	private void setFormula(String text) {
		formulaLabel.setText(text);
		fitFont(formulaLabel, 16);
	}

	// 수식이 길어지면 글자를 줄여서 화면 폭 안에 다 보이게 (최소 12)
	private void fitFont(JLabel label, int maxSize) {
		int width = label.getWidth() > 0 ? label.getWidth() : 280; // 화면에 뜨기 전이면 대략 폭
		int size = maxSize;
		Font font = label.getFont().deriveFont((float) size);
		while (size > 12 && label.getFontMetrics(font).stringWidth(label.getText()) > width) {
			size--;
			font = label.getFont().deriveFont((float) size);
		}
		label.setFont(font);
	}

	// 결과를 화면에 보여줄 글자로 바꾸기
	private String toResultText(double result) {
		if (Double.isInfinite(result) || Double.isNaN(result)) {
			return "Undefined"; // 0으로 나눈 경우 (9÷0, 0÷0)
		}
		if (Math.abs(result) < 1e8) {
			result = Math.round(result * 1e10) / 1e10; // 소수 10자리 반올림 (0.1+0.2 오차 제거)
		}
		if (result == (long) result) {
			return Long.toString((long) result); // 11.0 -> 11
		}
		return Double.toString(result); // 2.5 는 그대로
	}

	// 숫자, 연산자, 점: 수식 뒤에 이어 붙이기
	private void append(String input) {
		String formula = display.getText();
		char c = input.charAt(0);

		// 결과 뒤에 숫자나 점이 오면 새로 시작, 연산자면 결과에 이어서 계산
		if (formula.equals("Undefined") || (justCalculated && !isOperator(c))) {
			formula = "0";
		}
		justCalculated = false;

		char last = formula.charAt(formula.length() - 1);
		if (c == '.' && currentNumberHasDot(formula)) {
			return; // 1.2.3 막기
		} else if (last == ')' && !isOperator(c)) {
			setDisplay(formula + "×" + input); // (2+3)5 -> (2+3)×5
		} else if (last == '(' && isOperator(c)) {
			if (c == '-') {
				setDisplay(formula + input); // (-3 은 허용
			}
		} else if (c == '-' && (last == '×' || last == '÷')) {
			setDisplay(formula + input); // 5×-3 처럼 음수 입력 허용
		} else if (isOperator(c) && isOperator(last)) {
			String base = removeLastOperator(formula);
			if (base.length() == 0 || base.charAt(base.length() - 1) == '(') {
				return; // (- 뒤에 ×÷+ 가 와서 (× 가 되는 것 막기
			}
			setDisplay(base + input); // 연산자 연속 입력 막기
		} else if (formula.equals("0") && isDigit(c)) {
			setDisplay(input); // 0 뒤에 숫자면 0 지우고 시작
		} else {
			setDisplay(formula + input); // 연산자, 점은 그대로 붙임
		}
	}

	// 끝에 붙은 연산자 지우기
	private String removeLastOperator(String formula) {
		formula = formula.substring(0, formula.length() - 1);
		if (formula.length() > 0 && isOperator(formula.charAt(formula.length() - 1))) {
			formula = formula.substring(0, formula.length() - 1);
		}
		return formula;
	}

	// 지금 입력 중인 숫자에 점이 있는지
	private boolean currentNumberHasDot(String formula) {
		for (int i = formula.length() - 1; i >= 0; i--) {
			char ch = formula.charAt(i);
			if (ch == '.') {
				return true;
			}
			if (isOperator(ch) || ch == '(' || ch == ')') {
				return false;
			}
		}
		return false;
	}

	private boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}

	private boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '×' || c == '÷';
	}

	public static void main(String[] args) {
		new Report6();
	}
}

// 수식 계산 담당 (중위식 -> 후위식 -> 계산)
class PostfixCalculator {

	// 잘못된 수식이면 예외 발생 -> 화면 쪽에서 처리
	public double calculate(String formula) {
		String exp = toCalcFormula(formula);
		String post = toPostfix(exp + "=");
		return evalPostfix(post);
	}

	// ×÷ -> */ 변환
	private String toCalcFormula(String formula) {
		String exp = formula.replace("×", "*");
		return exp.replace("÷", "/");
	}

	// 숫자 토큰인지 확인 (2.5, .5 포함)
	private boolean isNumber(char c) {
		return (c >= '0' && c <= '9') || c == '.';
	}

	// PIS: In Stack 의 우선순위
	private int PIS(String op) {
		if (op == null) {
			return -1; // 스택이 비어 있음
		}
		return switch (op.charAt(0)) {
		case '*', '/', '~' -> 2;
		case '+', '-' -> 1;
		default -> 0; // '('
		};
	}

	// PIE: In Expression 의 우선순위
	private int PIE(String op) {
		return switch (op.charAt(0)) {
		case '(' -> 3;
		case '*', '/' -> 2;
		default -> 1; // '+', '-'
		};
	}

	// 중위식 -> 후위식
	private String toPostfix(String exp) {
		CalcStack<String> stack = new CalcStack<>();
		StringTokenizer st = new StringTokenizer(exp, "()+-*/=", true);
		String result = "";
		boolean expectNumber = true; // 다음에 숫자가 올 차례인지
		boolean negative = false; // 음수 부호가 붙었는지

		while (true) {
			String token = st.nextToken();
			char c = token.charAt(0);

			if (c == '-' && expectNumber) {
				negative = true; // -5, 5×-3 의 - 는 빼기가 아니라 음수 부호
			} else if (c == '(' && negative) {
				stack.push("~"); // -( 는 괄호 계산 결과의 부호를 바꿈 (~ = 부호 바꾸기)
				stack.push(token);
				negative = false;
			} else if (isNumber(c)) {
				if (negative) {
					token = "-" + token;
					negative = false;
				}
				result = result + token + " ";
				expectNumber = false;
			} else if (c == ')') {
				while (stack.peek().charAt(0) != '(') {
					result = result + stack.pop() + " ";
				}
				stack.pop(); // '(' 버리기
			} else if (c == '=') {
				while (stack.peek() != null) {
					result = result + stack.pop() + " ";
				}
				break;
			} else {
				while (PIS(stack.peek()) >= PIE(token)) {
					result = result + stack.pop() + " ";
				}
				stack.push(token);
				expectNumber = true;
			}
		}
		return result + "=";
	}

	// 후위식 계산
	private double evalPostfix(String exp) {
		CalcStack<Double> stack = new CalcStack<>();
		StringTokenizer st = new StringTokenizer(exp, " ");

		while (true) {
			String token = st.nextToken();
			char c = token.charAt(0);

			if (isNumber(c) || token.length() > 1) { // -3 처럼 두 글자 이상이면 음수
				stack.push(Double.parseDouble(token));
			} else if (c == '=') {
				return stack.pop();
			} else if (c == '~') {
				stack.push(-stack.pop()); // 부호 바꾸기
			} else {
				double b = stack.pop(); // 나중에 들어간 값이 오른쪽 피연산자
				double a = stack.pop();
				stack.push(operate(a, b, c));
			}
		}
	}

	// 연산자 하나 계산
	private double operate(double a, double b, char op) {
		return switch (op) {
		case '+' -> a + b;
		case '-' -> a - b;
		case '*' -> a * b;
		case '/' -> a / b;
		default -> 0; // + - * / 말고는 들어올 일 없음
		};
	}
}

// 계산기에서 쓰는 제네릭 스택
class CalcStack<T> {
	private int tos = 0; // 다음에 넣을 위치
	private Object[] stck = new Object[100];

	public void push(T item) {
		if (tos == 100) {
			return;
		}
		stck[tos] = item;
		tos++;
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		if (tos == 0) {
			return null;
		}
		tos--;
		return (T) stck[tos];
	}

	// 맨 위 값 확인만 하고 꺼내지는 않음
	@SuppressWarnings("unchecked")
	public T peek() {
		if (tos == 0) {
			return null;
		}
		return (T) stck[tos - 1];
	}
}