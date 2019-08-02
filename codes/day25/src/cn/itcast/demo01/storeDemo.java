package cn.itcast.demo01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class storeDemo {
	public static void main(String[] args) throws IOException{
		Properties pro = new Properties();
		pro.setProperty("name", "abbbb");
		pro.setProperty("age", "23");
		pro.setProperty("email", "12345789@foxmail.com");
		
		FileWriter fw = new FileWriter("C:\\Users\\Justzh_liao\\Desktop\\pro.properties");
		pro.store(fw, "");
		fw.close();
	}
}
