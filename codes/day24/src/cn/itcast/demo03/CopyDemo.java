package cn.itcast.demo03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 1.�ֽ�����д�����ֽ�
 * 2.�ֽ�����д�ֽ�����      611ms
 * 3.�ֽڻ���������д�����ֽ� 2967ms
 * 4.�ֽڻ���������д�ֽ����� 187ms
 * */
public class CopyDemo {
	public static void main(String[] args) throws IOException{
		long s = System.currentTimeMillis();
		copy_4(new File("C:\\Users\\Justzh_liao\\Desktop\\1.rar"),//ֻ�ܴ��ļ������ܴ��ļ���
				new File("C:\\Users\\Justzh_liao\\Desktop\\2.rar"));
		long e = System.currentTimeMillis();
		System.out.println(e-s);
	}
	/*
	 * 1.�ֽ�����д�����ֽ�
	 * */
	public static void copy_1(File scr,File desc)throws IOException{
		FileInputStream fis = new FileInputStream(scr);
		FileOutputStream fos = new FileOutputStream(desc);
		int len = 0;
		while((len = fis.read())!=-1){
			fos.write(len);
		}
		fis.close();
		fos.close();
	}
	/*
	 * 2.�ֽ�����д�ֽ�����
	 * */
	public static void copy_2(File scr,File desc)throws IOException{
		FileInputStream fis = new FileInputStream(scr);
		FileOutputStream fos = new FileOutputStream(desc);
		int len = 0;
		byte[] bytes = new byte[1024];
		while((len = fis.read(bytes))!=-1){
			fos.write(bytes,0,len);
		}
		fis.close();
		fos.close();
	}
	/*
	 * 3.�ֽڻ���������д�����ֽ�
	 * */
	public static void copy_3(File scr,File desc) throws IOException{
		FileInputStream fis = new FileInputStream(scr);
		FileOutputStream fos = new FileOutputStream(desc);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int len = 0;
		while((len = bis.read())!=-1){
			bos.write(len);
		}
		bis.close();
		bos.close();
	}
	/*
	 * 4.�ֽڻ���������д�ֽ�����
	 * */
	public static void copy_4(File scr,File desc)throws IOException{
		FileInputStream fis = new FileInputStream(scr);
		FileOutputStream fos = new FileOutputStream(desc);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int len = 0;
		byte[] bytes = new byte[1024];
		while((len = bis.read(bytes))!=-1){
			bos.write(bytes);
		}
		bis.close();
		bos.close();
	}
	
}
