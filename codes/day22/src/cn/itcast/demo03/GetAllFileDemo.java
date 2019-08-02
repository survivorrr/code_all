package cn.itcast.demo03;

import java.io.File;

public class GetAllFileDemo {
	public static void main(String[] args) {
		File dir = new File("E:\\javacode");
		getAllFile(dir);
	}
	
	public static void getAllFile(File dir){
		System.out.println(dir);
		File[] fileArr = dir.listFiles();
		for(File f:fileArr){
			if(f.isDirectory()){
				getAllFile(f);
			}else{
				System.out.println(f);
			}
			
		}
		
	}
}
