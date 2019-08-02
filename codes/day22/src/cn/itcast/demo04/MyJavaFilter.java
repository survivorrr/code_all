package cn.itcast.demo04;

import java.io.File;
import java.io.FileFilter;

public class MyJavaFilter implements FileFilter{
	public boolean accept(File pathname){
		if(pathname.isDirectory()){
			return true;
		}
		return pathname.getName().endsWith(".class");
	}
}
