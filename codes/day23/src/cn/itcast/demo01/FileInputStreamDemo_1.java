package cn.itcast.demo01;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo_1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Justzh_liao\\Desktop\\b.txt");
		byte[] b = new byte[2];//“ª∞„–¥1024
		int len = 0;
		
		while((len = fis.read(b)) != -1){
//			len = fis.read(b);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
			System.out.print(new String(b,0,len));
	/*		for(int i=0;i<b.length;i++){
				System.out.print((char)b[i]);
			}*/
		}
		fis.close();
	}
}
