package cn.itcast.demo05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedCopyDemo {
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("C:\\Users\\Justzh_liao\\Desktop\\2.txt");
		BufferedReader bfr = new BufferedReader(fr);
		FileWriter fw = new FileWriter("C:\\Users\\Justzh_liao\\Desktop\\3.txt");
		BufferedWriter bfw = new BufferedWriter(fw);
		String line = null;
		while((line = bfr.readLine()) != null){
			bfw.write(line);
			bfw.newLine();
			bfw.flush();
		}
		bfr.close();
		bfw.close();
	}
}
