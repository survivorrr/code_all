package cn.itcast.demo01;

import java.io.FileInputStream;

import java.io.IOException;

public class FileInputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Justzh_liao\\Desktop\\b.txt");
        int len;
		while((len = fis.read()) != -1){
			System.out.print((char)len);
		}
		fis.close();
	}
}
