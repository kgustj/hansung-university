package report;

public class Report2 {
	public static void main(String[] args) {
		if (args.length < 5) {
			System.out.println("숫자를 5개 이상 입력하세요.");
			return;
		}

		double[] a = new double[args.length];
		for (int i = 0; i < args.length; i++) {
			a[i] = Double.parseDouble(args[i]);
		}

		for (int i = 0; i < a.length; i++) {
			double min = a[i];
			int index = i;

			for (int j = i; j < a.length; j++) {
				if (min > a[j]) {
					min = a[j];
					index = j;
				}
			}

			double temp = a[i];
			a[i] = a[index];
			a[index] = temp;
		}

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
