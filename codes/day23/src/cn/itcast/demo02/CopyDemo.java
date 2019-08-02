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
			throw new RuntimeException("写入失败");
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
					throw new RuntimeException("文件复制失败");
				}finally{
					try{
						if(fos1!=null){//对象建立成功才关，没建立成功就不需要关，否则浪费资源
							fos1.close();
						}
					}catch(IOException ex){
							throw new RuntimeException("资源释放失败");
						}finally{
							try{
								if(fis!=null){//对象建立成功才关，没建立成功就不需要关，否则浪费资源
									fis.close();
								}
							}catch(IOException ex){
									throw new RuntimeException("资源释放失败");
								}
							}
						}
					}
				}
}			

