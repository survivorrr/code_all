package cn.itcast.demo02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {
	public static void main(String[] args)   {
	//	File file = new File("C:\\Users\\Justzh_liao\\Desktop\\a.txt");
		try{
			FileOutputStream fos = new FileOutputStream("C:\\Users\\Justzh_liao\\Desktop\\a.txt");
		    fos.write("hello\r\nworld".getBytes());
		}catch(IOException ex){
			System.out.println(ex);
			throw new RuntimeException("д��ʧ��");
		}finally{
		//	fos.close();
			FileInputStream fis = null;
			FileOutputStream fos1 = null;
				int len = 0;
				try{
					fis = new FileInputStream("C:\\Users\\Justzh_liao\\Desktop\\a.txt");
					fos1 = new FileOutputStream("C:\\Users\\Justzh_liao\\Desktop\\b.txt");
					while((len = fis.read()) != -1){
						fos1.write(len);
					}
				
				}catch(IOException ex){
					System.out.println(ex);
					throw new RuntimeException("�ļ�����ʧ��");
				}finally{
					try{
						if(fos1!=null){//�������ɹ��Źأ�û�����ɹ��Ͳ���Ҫ�أ������˷���Դ
							fos1.close();
						}
					}catch(IOException ex){
							throw new RuntimeException("��Դ�ͷ�ʧ��");
						}finally{
							try{
								if(fis!=null){//�������ɹ��Źأ�û�����ɹ��Ͳ���Ҫ�أ������˷���Դ
									fis.close();
								}
							}catch(IOException ex){
									throw new RuntimeException("��Դ�ͷ�ʧ��");
								}
							}
						}
					}
				}
}			

