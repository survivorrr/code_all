package cn.itcast.demo01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo {
	public static void main(String[] args) throws IOException{
//		gbkWriter();
		utfWriter();
	}
	
	public static void gbkWriter() throws IOException{
		//创建字节输出流，绑定目标文件
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Justzh_liao\\Desktop\\1.txt");
		//创建转换流对象，构造方法保证字节输出流，并指定编码表GBK，其实默认就是GBK
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		osw.write("你好啊");
		osw.flush();
		osw.close();		
	}
	
	public static void utfWriter() throws IOException{
		//创建字节输出流，绑定目标文件
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Justzh_liao\\Desktop\\2.txt");
		//创建转换流对象，构造方法保证字节输出流，并指定编码表UTF-8
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		osw.write("你好啊");
		osw.flush();
		osw.close();
	}
}
