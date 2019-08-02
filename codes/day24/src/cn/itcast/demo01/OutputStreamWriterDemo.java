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
		//�����ֽ����������Ŀ���ļ�
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Justzh_liao\\Desktop\\1.txt");
		//����ת�������󣬹��췽����֤�ֽ����������ָ�������GBK����ʵĬ�Ͼ���GBK
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		osw.write("��ð�");
		osw.flush();
		osw.close();		
	}
	
	public static void utfWriter() throws IOException{
		//�����ֽ����������Ŀ���ļ�
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Justzh_liao\\Desktop\\2.txt");
		//����ת�������󣬹��췽����֤�ֽ����������ָ�������UTF-8
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		osw.write("��ð�");
		osw.flush();
		osw.close();
	}
}
