package cn.itcast.demo04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("C:\\Users\\Justzh_liao\\Desktop\\2.txt");
		BufferedReader bfr = new BufferedReader(fr);
		String line = null;
		int numberline = 0;
		while((line = bfr.readLine()) != null){
			numberline++;
			System.out.println(numberline +" "+line);
		}
/*		String line = bfr.readLine();
		System.out.println(line);
		
		String line1 = bfr.readLine();
		System.out.println(line1);
		
		String line2 = bfr.readLine();
		System.out.println(line2);
		
		String line3 = bfr.readLine();
		System.out.println(line3);
		
		String line4 = bfr.readLine();
		System.out.println(line4);
		
		String line5 = bfr.readLine();
		System.out.println(line5);*/
		
		
		bfr.close();
	}
}
