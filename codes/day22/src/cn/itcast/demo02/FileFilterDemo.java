package cn.itcast.demo02;

import java.io.File;

public class FileFilterDemo {
	public static void main(String[] args) {
		File file = new File("E:\\javacode\\day07");
		File[] fileArr = file.listFiles(new MyFilter());
		for(File f:fileArr){
			System.out.println(f);
		}
	}
}
