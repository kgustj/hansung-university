package report;

import java.util.StringTokenizer;

public class Report4 {
	public static void main(String[] args) {
		String sample = new String("2.0*3.0-((4.0+5.0)*2.0)-4.0+4.0=");
		StringTokenizer st = new StringTokenizer(sample, "()+-*/=", true);

		double sum = 0;
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.print(token + " ");

			char c = token.charAt(0);
			if ('0' <= c && c <= '9') {
				sum += Double.parseDouble(token);
			}
		}

		System.out.println("\n숫자들의 합: " + sum);
	}
}