package cn.itcast.demo02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterDemo {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\Justzh_liao\\Desktop\\1.txt");
		PrintWriter fw = new PrintWriter(file);
		fw.println(100);
		fw.write(100);
		fw.close();
	}
}
