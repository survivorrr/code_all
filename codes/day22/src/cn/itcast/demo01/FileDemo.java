package cn.itcast.demo01;

import java.io.File;

public class FileDemo {
	public static void main(String[] args) {
		File file1 = new File("c:","windows");//���췽��File(String parent,String child)
		System.out.println(file1);
		
		File file2 = new File("e:\\javacode\\day01");//���췽��File(String pathname)
		System.out.println(file2);
		
		File file3 = new File("c:\\windows");
		System.out.println(file3);
	}
	
}
