package cn.itcast.demo03;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyDemo {
	public static void main(String[] args) {
		FileWriter fw = null;
		FileReader fr = null;
		try{
			fw = new FileWriter("C:\\Users\\Justzh_liao\\Desktop\\2.txt");
			fr = new FileReader("C:\\Users\\Justzh_liao\\Desktop\\1.txt");
			char[] ch = new char[1024];
			int len;
			while((len = fr.read(ch)) != -1){
				fw.write(ch,0,len);
				fw.flush();
			}
		}catch(IOException ex){
			System.out.println(ex);
			throw new RuntimeException("copy failly");
		}finally{
			try{
				if(fw != null){
					fw.close();
				}
			}catch(IOException ex){
			System.out.println(ex);
			throw new RuntimeException("close failly");
		}finally{
			try{
				if(fr != null){
					fr.close();
				}
		}catch(IOException ex){
			System.out.println(ex);
			throw new RuntimeException("close failly");
		}
	 }
    }
}
}
