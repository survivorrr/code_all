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
			fos = new FileOutputStream("C:\\Users\\Justzh_liao\\Desktop\\新建文件夹\\paper1.rar");
			fis = new FileInputStream("C:\\Users\\Justzh_liao\\Desktop\\新建文件夹\\paper.rar");
			byte [] bytes = new byte [1024*10];//这个是CopyDemo_1的改良版，运行更快
			while((len = fis.read(bytes))!= -1){
				fos.write(bytes,0,len); 
			}
		}catch(IOException ex){
			System.out.println(ex);
			throw new RuntimeException("复制文件失败");
		}finally{
			try{
				if(fos != null){	
					fos.close();
				}
			}catch(IOException ex){
				System.out.println(ex);
				throw new RuntimeException("关闭资源失败");
			}finally{
				try{
					if(fis != null){
						fis.close();
					  }
				}catch(IOException ex){
							System.out.println(ex);
							throw new RuntimeException("关闭资源失败");
						}
					}
				}
		long e = System.currentTimeMillis();
		System.out.println(e-s);
		}
	
}
