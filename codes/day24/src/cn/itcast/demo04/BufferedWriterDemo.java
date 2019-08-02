package cn.itcast.demo04;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BufferedWriterDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Justzh_liao\\Desktop\\2.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bf = new BufferedWriter(osw);
		bf.write("glujg;ojsg");
		bf.newLine();
		bf.write("¹þÊÕ¸î»ú".toCharArray());
		bf.flush();
		bf.close();
	}
}
