package cn.tedu.jdbc.day01;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Properties_Demo {
	public static void main(String[] args) throws IOException {
		//Properties 就是为了读取*.properties文件而设计的API
		//其底层就是文本文件IO，Properties本身实现Map接口，内部是散列表，限定key和Value
		//都是String 类型。
		
		//方法：load(流) 将文件读取为散列表
		//String getProperty(key) 查询value
		/*使用步骤
		 * 1.创建Properties对象
		 * */
		Properties pro = new Properties();
		System.out.println(pro);
		System.out.println(pro.size());
		System.out.println(pro.isEmpty());
		//2.利用load方法读取方法
		InputStream in = Properties_Demo.class.getClassLoader().
					getResourceAsStream("db.properties");
		//执行以后，将文件内容读取到散列表中了
		pro.load(in);
		System.out.println(pro);
		System.out.println(pro.size());
		//3.查找文件内容,就是读取文件的内容
		String s = pro.getProperty("jdbc.driver");
		System.out.println(s);
	}
}
