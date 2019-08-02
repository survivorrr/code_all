package cn.tedu.jdbc.day03;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;

import cn.tedu.jdbc.day02.DbUtils;

/*
 * ִ��һ��sql(DDL��֧�����񣬼���֧�ֻع�)
 * */
public class Batch_sql_Demo {
	public static void main(String[] args) {
		String sql1="create table log_01("
				+ "id number(8),"
				+ "msg varchar2(100))";
		String sql2="create table log_02("
				+ "id number(8),"
				+ "msg varchar2(100))";
		String sql3="create table log_03("
				+ "id number(8),"
				+ "msg varchar2(100))";
		//ִ��һ��sql
		Connection conn = null;
				try {
					conn = DbUtils.getConnection();
					Statement state = conn.createStatement();
					//sql1��ӵ�Statement�Ļ�����
					state.addBatch(sql1);
					state.addBatch(sql2);
					state.addBatch(sql3);
					//ִ��һ��sql
					int[] arry = state.executeBatch();
					System.out.println(Arrays.toString(arry));
				}catch(Exception ex) {
					ex.printStackTrace();
				}finally {
					DbUtils.close(conn);
				}
	}
}
