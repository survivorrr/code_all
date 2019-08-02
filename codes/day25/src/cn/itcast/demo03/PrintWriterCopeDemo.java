package cn.itcast.demo03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterCopeDemo {
	public static void main(String[] args) throws IOException {
		FileReader file1 = new FileReader("C:\\Users\\Justzh_liao\\Desktop\\3.txt");
		FileWriter file2 = new FileWriter("C:\\Users\\Justzh_liao\\Desktop\\4.txt");
		BufferedReader bfr = new BufferedReader(file1);
		PrintWriter pw = new PrintWriter(file2, true);
		String line = null;
		while((line = bfr.readLine()) != null){
			pw.println(line);
		}
		pw.close();
		bfr.close();
		
	}
		
	
	//这是之前学过的copy方法
/*		FileReader file1 = new FileReader("C:\\Users\\Justzh_liao\\Desktop\\3.txt");
		FileWriter file2 = new FileWriter("C:\\Users\\Justzh_liao\\Desktop\\4.txt");
	//	PrintWriter pw = new PrintWriter(file2);
		char[] ch = new char[1024];
		int len = 0;
		while((len = file1.read(ch))!= -1){
			file2.write(ch,0,len);
			file2.flush();
			}
		file1.close();
		file2.close();
		}
		//pw.close();
		*/
		
		
}
