package report;

import java.util.StringTokenizer;

class GStack<T> {
	int tos;
	Object[] stck;

	public GStack() {
		tos = 0;
		stck = new Object[100];
	}

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
}

public class Report5 {
	// 스택 맨 위 확인: pop 후 다시 push
	static <T> T peek(GStack<T> s) {
		T top = s.pop();
		if (top != null) {
			s.push(top);
		}
		return top;
	}

	// PIS: In Stack 의 우선순위
	static int PIS(String op) {
		if (op == null) {
			return -1;
		}
		char c = op.charAt(0);
		if (c == '*' || c == '/') {
			return 2;
		} else if (c == '+' || c == '-') {
			return 1;
		}
		return 0;
	}

	// PIE: In Expression 의 우선순위
	static int PIE(String op) {
		char c = op.charAt(0);
		if (c == '(') {
			return 3;
		} else if (c == '*' || c == '/') {
			return 2;
		}
		return 1;
	}

	// 중위 표기식 -> 후위 표기식
	static String postfix(String exp) {
		GStack<String> stack = new GStack<String>();
		StringTokenizer st = new StringTokenizer(exp, "()+-*/=", true);
		String result = "";

		while (true) {
			String token = st.nextToken();
			char c = token.charAt(0);

			if (c >= '0' && c <= '9') {
				result = result + token + " ";
			} else if (c == ')') {
				while (peek(stack).charAt(0) != '(') {
					result = result + stack.pop() + " ";
				}
				stack.pop();
			} else if (c == '=') {
				while (peek(stack) != null) {
					result = result + stack.pop() + " ";
				}
				break;
			} else {
				while (PIS(peek(stack)) >= PIE(token)) {
					result = result + stack.pop() + " ";
				}
				stack.push(token);
			}
		}
		result = result + "=";
		return result;
	}

	// 후위 표기식 계산
	static double evalPostfix(String exp) {
		GStack<Double> stack = new GStack<Double>();
		StringTokenizer st = new StringTokenizer(exp, " ");

		while (true) {
			String token = st.nextToken();
			char c = token.charAt(0);

			if (c >= '0' && c <= '9') {
				stack.push(Double.parseDouble(token));
			} else if (c == '=') {
				return stack.pop();
			} else {
				double b = stack.pop();
				double a = stack.pop();
				if (c == '+') {
					stack.push(a + b);
				} else if (c == '-') {
					stack.push(a - b);
				} else if (c == '*') {
					stack.push(a * b);
				} else if (c == '/') {
					stack.push(a / b);
				}
			}
		}
	}

	public static void main(String[] args) {
		String exp = new String("2.0*3.0-((4.0+5.0)*2.0)-4.0+5.0=");

		String post = postfix(exp);
		System.out.println("중위 표기식: " + exp);
		System.out.println("후위 표기식: " + post);
		System.out.println("계산 결과: " + evalPostfix(post));
	}
}