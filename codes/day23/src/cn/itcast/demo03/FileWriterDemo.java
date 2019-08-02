package cn.itcast.demo03;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
	public static void main(String[] args) throws IOException{
		FileWriter fw = new FileWriter("C:\\Users\\Justzh_liao\\Desktop\\1.txt");
		fw.write("aghoieugjorhsdfhdfhfghfdhhdshtehtejg");
		fw.flush();
		fw.close();
		
		
		FileReader fr = new FileReader("C:\\Users\\Justzh_liao\\Desktop\\1.txt");
		int len = 0;
		char[] ch = new char[1024];
		while((len = fr.read(ch))!=-1){
			System.out.print(new String(ch,0,len));
		}
		
		
	}
}
