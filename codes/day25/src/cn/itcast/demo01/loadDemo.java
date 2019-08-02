package cn.itcast.demo01;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class loadDemo {
	public static void main(String[] args) throws IOException {
		Properties pro = new Properties();
		FileReader fr = new FileReader("C:\\Users\\Justzh_liao\\Desktop\\pro.properties");
		pro.load(fr);
		fr.close();
		System.out.println(pro);
	}
}
