package ch08_io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReadHangulEx {
	public static void main(String[] args) {
		InputStreamReader in = null;
		FileInputStream fin = null;
		try {
			String path = "data/hangul.txt";
			fin = new FileInputStream(path);
			// in = new InputStreamReader(fin, "US-ASCII");
			in = new InputStreamReader(fin, "UTF-8");
			int c;

			System.out.println("인코딩 문자 집합은 " + in.getEncoding());
			while ((c = in.read()) != -1) {
				System.out.print((char) c);
			}
			in.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
	}
}
