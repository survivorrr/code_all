package FileTest;

import java.io.File;
import java.io.IOException;

public class File_Test {
	public static void main(String[] args) throws IOException{
		File file = new File("0.0");
		System.out.println(System.getProperty("user.dir"));//��Ŀ¼
		System.out.println(file.getName());
		System.out.println(file.createNewFile());
		
		File newFile = new File(System.currentTimeMillis()+"");
		System.out.println("newFile�����Ƿ���ڣ�"+newFile.exists());
		System.out.println(newFile.createNewFile());
	}
}
