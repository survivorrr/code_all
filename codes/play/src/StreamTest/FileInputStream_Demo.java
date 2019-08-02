package StreamTest;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream_Demo {
	public static void main(String[] args) throws IOException{
		FileInputStream fis = new FileInputStream("E:\\workspace\\play\\src\\"
				+ "StreamTest\\FileInputStream_Demo.java");
		byte[] bbuf = new byte[1024];
		int hasRead = 0;
		while((hasRead = fis.read(bbuf)) > 0) {
			System.out.println(bbuf.length);
			System.out.println(new String(bbuf,0,hasRead));
		}
		
		//¹Ø±ÕÁ÷
		fis.close();
	}
}
