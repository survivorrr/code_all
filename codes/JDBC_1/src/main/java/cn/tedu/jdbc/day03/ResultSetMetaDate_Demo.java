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
			//这个*号决定了查询整个表，和那种select balance from table where id=1 不同
			//这种sql就决定了只查询id=1时的balance,问这个balance只有一行一列
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			//结果集元数据
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
