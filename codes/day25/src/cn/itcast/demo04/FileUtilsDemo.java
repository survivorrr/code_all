package cn.itcast.demo04;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileUtilsDemo {
	public static void main(String[] args) throws IOException {
		function_2();
		
	}
	
	public static void function_1() throws IOException{
		File file = new File("C:\\Users\\Justzh_liao\\Desktop\\1.txt");
		FileUtils.writeStringToFile(file, "我爱java");
	}
	
	public static void function_2() throws IOException{
		
		File file = new File("C:\\Users\\Justzh_liao\\Desktop\\通知附件（最新版）");
		File file1 = new File("C:\\Users\\Justzh_liao\\Desktop\\通知附件（最新版）1");
		
		FileUtils.copyDirectoryToDirectory(file, file1);
	}
}
