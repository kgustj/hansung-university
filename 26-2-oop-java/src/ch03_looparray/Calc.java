package ch03_looparray;

public class Calc {
	public static void main(String[] args) {
		double sum = 0.0;

		for (int i = 0; i < args.length; i++) {
			// sum += Double.parseDouble(args[i]);
			sum += Integer.parseInt(args[i]);
		}

		System.out.println("합계: " + sum);
	}
}
