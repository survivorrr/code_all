package cn.itcast.demo01;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Justzh_liao\\Desktop\\a.txt");
		fos.write(100);
		
		fos.write(49);
		fos.write(48);
		fos.write(48);
		fos.write("\r\n".getBytes());
		fos.write("hello\r\n".getBytes());
		fos.write("world".getBytes());
		fos.close();
		
		
	}
}
