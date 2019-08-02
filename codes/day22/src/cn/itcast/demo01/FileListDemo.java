package cn.itcast.demo01;

import java.io.File;

public class FileListDemo {
	public static void main(String[] args) {
		filelistfunction();
	}
	public static void filelistfunction(){
		File file = new File("E:\\javacode");
		String[] strArr = file.list();
	/*	for(int i=0;i<strArr.length;i++){
			String s = strArr[i];
			System.out.println(s);
		}*/
		for(String str:strArr){
			System.out.println(str);
		}
	}
}
