package cn.tedu.jdbc.day03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import cn.tedu.jdbc.day02.DbUtils;

public class ResultSetMetaDate_Demo {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			String sql = "select * from Login_user";
			//���*�ž����˲�ѯ������������select balance from table where id=1 ��ͬ
			//����sql�;�����ֻ��ѯid=1ʱ��balance,�����balanceֻ��һ��һ��
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			//�����Ԫ����
			ResultSetMetaData rsmd = rs.getMetaData();
			int n = rsmd.getColumnCount();
			System.out.println(n);
			for(int i=1;i<=n;i++) {
				System.out.print(rsmd.getColumnName(i)+"  ");
			}
			System.out.println();
			while(rs.next()) {
				for(int i=1;i<=n;i++) {
					System.out.print(rs.getString(i)+"   ");
				}
				System.out.println();
			}
/*			String name1 = rsmd.getColumnName(1);
			String name2 = rsmd.getColumnName(2);
			String name3 = rsmd.getColumnName(3);
			System.out.println(n+","+name1+","+name2+","+name3);*/
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}finally {
			DbUtils.close(conn);
		}
	}
}
