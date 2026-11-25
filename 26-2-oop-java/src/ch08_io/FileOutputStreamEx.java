package ch08_io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx {
	public static void main(String[] args) {
		byte[] data = {10, -3, 100, 0, 127};
		String path = "data/data.bin";
		try {
			FileOutputStream out = new FileOutputStream(path);
			out.write(data); // 배열 전체를 한 번에 기록 (바이트 그대로)
			out.close();
			System.out.println(data.length + "바이트를 " + path + "에 저장했습니다.");
		} catch (IOException e) {
			System.out.println("저장 실패: 경로를 확인하세요.");
		}
	}
}