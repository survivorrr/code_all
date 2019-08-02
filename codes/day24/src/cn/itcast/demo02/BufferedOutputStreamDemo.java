package cn.itcast.demo02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class BufferedOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Justzh_liao\\Desktop\\1.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		bos.write(55);
		byte[] bytes = new byte[1024];
		bytes = "\r\nhelloworld".getBytes();
		bos.write(bytes);

		bos.close();

	}
}
