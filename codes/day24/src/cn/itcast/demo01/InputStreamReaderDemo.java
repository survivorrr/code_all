package cn.itcast.demo01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {
public static void main(String[] args) throws IOException {
	gbkReader();
	}
	
	public static void gbkReader() throws IOException{
		FileInputStream fis = new FileInputStream("C:\\Users\\Justzh_liao\\Desktop\\2.txt");
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		int len = 0;
		char[] b = new char[1024];//InputStreamReader把字节转为字符，所以创建一个字符数组存储。
		while((len = isr.read(b))!=-1){
			System.out.print(new String(b,0,len));
		}
		isr.close();
	}
}
