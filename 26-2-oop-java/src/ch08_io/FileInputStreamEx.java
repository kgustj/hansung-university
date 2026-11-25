package ch08_io;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamEx {
	public static void main(String[] args) {
		byte[] b = new byte[100];
		try {
			String path = "data/data.bin";
			FileInputStream fin = new FileInputStream(path);
			int c, n = 0;
			while ((c = fin.read()) != -1) {
				b[n] = (byte) c;
				n++;
			}
			fin.close();
			System.out.print("읽은 " + n + "바이트: ");
			for (int i = 0; i < n; i++) {
				System.out.print(b[i] + " ");
			}
			System.out.println();
		} catch (IOException e) {
			System.out.println("읽기 실패: 경로를 확인하세요.");
		}
	}
}
