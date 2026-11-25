package report;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Report3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문장을 입력하세요: ");
		String str = scanner.nextLine();

		int[] lower = new int[26];
		int[] upper = new int[26];

		for (int i = 0; i < str.length(); i++) {
			if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
				lower[str.charAt(i) - 'a']++;
			}
			if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
				upper[str.charAt(i) - 'A']++;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (lower[i] + upper[i] > 0) {
				System.out.printf("%c=%d개 ", (char) (i + 97), lower[i]);
				System.out.printf("%c=%d개 ", (char) (i + 65), upper[i]);
				System.out.printf("%c+%c의 합은 %d개\n", (char) (i + 97), (char) (i + 65), lower[i] + upper[i]);
			}
		}

		String[] temp = str.split(" +"); // + 기호 중요
		System.out.printf("단어의 갯수는% d개\n", temp.length);

		StringTokenizer st = new StringTokenizer(str, " +");
		System.out.printf("단어의 갯수는% d개\n", st.countTokens());

		scanner.close();
	}
}
