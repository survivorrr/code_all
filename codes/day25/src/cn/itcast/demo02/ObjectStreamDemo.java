package cn.itcast.demo02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		ObjectOutputStream_function();
		ObjectInputStream_function();
	}
	
	public static void ObjectOutputStream_function() throws IOException{
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\1.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Person p = new Person("zhangsan",20);
		oos.writeObject(p);
		oos.close();	
	}
	
	public static void ObjectInputStream_function() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\1.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object p = ois.readObject();
		System.out.println(p);
	}
}





