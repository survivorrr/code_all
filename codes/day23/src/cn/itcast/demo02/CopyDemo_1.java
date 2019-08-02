package cn.itcast.demo02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo_1 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		int len = 0;
		try{
			fos = new FileOutputStream("C:\\Users\\Justzh_liao\\Desktop\\新建文件夹\\paper1.rar");
			fis = new FileInputStream("C:\\Users\\Justzh_liao\\Desktop\\新建文件夹\\paper.rar");
			while((len = fis.read())!= -1){
				fos.write(len); 
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
		}
}
