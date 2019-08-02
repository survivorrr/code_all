package cn.itcast.demo01;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
	public static void main(String[] args) throws IOException{
		function();
	}
	
	
	public static void function() throws IOException{
		File file = new File("C:\\Users\\Justzh_liao\\Desktop\\paper.text");
		boolean b = file.createNewFile();
		System.out.println(b);
	}
}
