package ch03_looparray;

// 완성

public class IrregularArray {
	public static void main(String[] args) {
		int intArray[][] = new int[4][];

		for (int i = 0; i < 4; i++) {
			intArray[i] = new int[i + 3];
		}

		for (int i = 0; i < intArray.length; i++) {
			for (int j = 0; j < intArray[i].length; j++) {
				intArray[i][j] = (i + 1) * 10 + j;
			}
		}

		for (int i = 0; i < intArray.length; i++) {
			for (int j = 0; j < intArray[i].length; j++) {
				System.out.print(intArray[i][j] + " ");
			}
			System.out.println();
		}
	}
}
