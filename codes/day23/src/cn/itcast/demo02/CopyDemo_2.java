package cn.itcast.demo02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo_2 {
	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		FileOutputStream fos = null;
		FileInputStream fis = null;
		int len = 0;
		try{
			fos = new FileOutputStream("C:\\Users\\Justzh_liao\\Desktop\\�½��ļ���\\paper1.rar");
			fis = new FileInputStream("C:\\Users\\Justzh_liao\\Desktop\\�½��ļ���\\paper.rar");
			byte [] bytes = new byte [1024*10];//�����CopyDemo_1�ĸ����棬���и���
			while((len = fis.read(bytes))!= -1){
				fos.write(bytes,0,len); 
			}
		}catch(IOException ex){
			System.out.println(ex);
			throw new RuntimeException("�����ļ�ʧ��");
		}finally{
			try{
				if(fos != null){	
					fos.close();
				}
			}catch(IOException ex){
				System.out.println(ex);
				throw new RuntimeException("�ر���Դʧ��");
			}finally{
				try{
					if(fis != null){
						fis.close();
					  }
				}catch(IOException ex){
							System.out.println(ex);
							throw new RuntimeException("�ر���Դʧ��");
						}
					}
				}
		long e = System.currentTimeMillis();
		System.out.println(e-s);
		}
	
}
