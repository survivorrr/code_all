package cn.tedu.jdbc.day01;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Properties_Demo {
	public static void main(String[] args) throws IOException {
		//Properties ����Ϊ�˶�ȡ*.properties�ļ�����Ƶ�API
		//��ײ�����ı��ļ�IO��Properties����ʵ��Map�ӿڣ��ڲ���ɢ�б��޶�key��Value
		//����String ���͡�
		
		//������load(��) ���ļ���ȡΪɢ�б�
		//String getProperty(key) ��ѯvalue
		/*ʹ�ò���
		 * 1.����Properties����
		 * */
		Properties pro = new Properties();
		System.out.println(pro);
		System.out.println(pro.size());
		System.out.println(pro.isEmpty());
		//2.����load������ȡ����
		InputStream in = Properties_Demo.class.getClassLoader().
					getResourceAsStream("db.properties");
		//ִ���Ժ󣬽��ļ����ݶ�ȡ��ɢ�б�����
		pro.load(in);
		System.out.println(pro);
		System.out.println(pro.size());
		//3.�����ļ�����,���Ƕ�ȡ�ļ�������
		String s = pro.getProperty("jdbc.driver");
		System.out.println(s);
	}
}
