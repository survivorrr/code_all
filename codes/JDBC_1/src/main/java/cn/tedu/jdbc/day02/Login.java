package cn.tedu.jdbc.day02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

/*
 * ע����ʾ
 * create table Login_user(
 * 	id number(6),
 * 	name varchar2(100),
 * 	pwd varchar2(100)
 * );
 * 
 * insert into Login_user (id,name,pwd) values(1,'Tom','123');
 * ....
 * */
public class Login {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("username:");
		String name = sc.nextLine();
		System.out.println("password:");
		String pwd = sc.nextLine();
		boolean flag = login(name,pwd);
		if(flag == false) {
			System.out.println("��¼ʧ��!!!");
		}else{
			System.out.println("��¼�ɹ�!!!");
		}
	}
	
	public static boolean login(String name,String pwd) {
		
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			//��ת���ַ�\'�ͷֺ�"֮�䲻���пո��пո����ʽ��name��pwd�ַ������˿ո�
			//����    where name=' zhangsan ' and pwd=' 123 ',ʵ���в����пո��
			String sql = "select * from Login_user "
				 + "where name=\'"+name+"\' and pwd=\'"+pwd+"\'";
			/*����sql���Ͷ�����Ϊһ��һ�У������������int m = rsmd.getColumnCount();
			 * m��ֵ����1����rs.getInt()����ֻ����1����Ϊsql��������ֻ��ѯ����ĳ��ĳ�е�
			 * һ������Ľ��
			 * */

			System.out.println(sql);
/*			//û��\'(ת�嵥����)��ʵҲ������
 * 			String sql = "select count(*) as c from Login_user "
					+ "where name= '"+name+"' and pwd= '"+pwd+"' ";*/
			Statement stat = conn.createStatement();
			ResultSet set = stat.executeQuery(sql);
			ResultSetMetaData rsmd = set.getMetaData();
			int m = rsmd.getColumnCount();
			System.out.println(m);
			for(int i=1;i<=m;i++) {
				System.out.println(rsmd.getColumnName(i));
			}
			while(set.next()) {
				System.out.println(set.getString(2));
/*				
				System.out.println(set.getString(2));
				û�еڶ���,����sql���ѡ����ֻ��һ�У���Ϊsql����ѯ�Ľ��ֻ��һ��ĳ��ĳ�е�
				��һ������Ľ��������ֻ��set.getInt(1)��ֵ
*/
				int n = set.getInt("id");
				return n>=1;
			}	
			return false;
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}finally {
			DbUtils.close(conn);
		}
	}
}
