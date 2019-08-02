package cn.itcast.demo02;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {
	public static void main(String[] args) throws IOException{
		FileInputStream fis = new FileInputStream("C:\\Users\\Justzh_liao\\Desktop\\1.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
/*		byte[] bytes = new byte[1024];
		int len = bis.read(bytes);
		System.out.println(new String(bytes,0,len));*/
		
		byte[] bytes = new byte[10];
		int len = 0;
		while((len = bis.read(bytes)) != -1){
			System.out.print(new String(bytes,0,len));
		}
	}
}
