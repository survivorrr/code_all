package cn.itcast.demo04;

import java.io.File;

public class MuLuBianLiDemo {
	public static void main(String[] args) {
		File file = new File("e:\\javacode");
		getDirFunction(file);
	}
	
	public static void getDirFunction(File file){
		System.out.println(file);
		File[] fileArr = file.listFiles(new MyJavaFilter());
		for(File f : fileArr){
			if(f.isDirectory()){
				getDirFunction(f);
			}else{
				System.out.println(f);
			}
		}
	}
}
