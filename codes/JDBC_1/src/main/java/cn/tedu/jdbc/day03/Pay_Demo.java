package cn.tedu.jdbc.day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import cn.tedu.jdbc.day02.DbUtils;

public class Pay_Demo {
	public static void main(String[] args) {
		pay(2,3,10000);//从?号账户汇?元钱到?号账户
	
	}
	
	public static void pay(int from,int to,double money){
		String sql1 = "update a_account set balance=balance+? where id=?";
		String sql2 = "select * from a_account where id=?";
//		String sql3 = "select name from a_account where id=?";
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			//取消自动提交
			conn.setAutoCommit(false);
			PreparedStatement pstate = conn.prepareStatement(sql1);
			//减钱
			pstate.setDouble(1, -money);
			pstate.setInt(2, from);
			int n = pstate.executeUpdate();
			if(n!=1) {
				throw new Exception("扣错了");
			}
			//增加
			pstate.setDouble(1, money);
			pstate.setInt(2, to);
			n = pstate.executeUpdate();
			if(n!=1) {
				throw new Exception("加错了");
			}
			//关闭原来的执行平台
			pstate.close();
			//检查
			pstate = conn.prepareStatement(sql2);
			pstate.setInt(1, from);
			ResultSet rs = pstate.executeQuery();
/*			ResultSetMetaData rsmd = rs.getMetaData();
			int m = rsmd.getColumnCount();
			System.out.println(m);*/
			while(rs.next()) {
			/*	double balance = rs.getDouble(1);//sql语句决定了只查询了id=?时的balance
			             	                                                      故只有一行一列，当括号中为2时发生错误的列索引*/
				double balance = rs.getDouble("balance");
				if(balance<0) {
					throw new Exception(rs.getString(2)+"账号余额不足"+money);
				}
			}
			
/*			while(rs.next()) {
				
				double balance = rs.getDouble(1);//sql语句决定了只查询了id=?时的balance
				故只有一行一列，当括号中为2时发生错误的列索引
				double balance = rs.getDouble("balance");
				if(balance<0) {
					pstate.close();
					pstate = conn.prepareStatement(sql3);
					pstate.setInt(1, from);
					rs = pstate.executeQuery();
					while(rs.next()) {
						throw new Exception(rs.getString(1)+"账号余额不足"+money);
					}
				}
			}*/
			
			//手动提交
			conn.commit();
			System.out.println("汇款"+money+"元成功，请到数据库中查询!!!");
		}catch(Exception ex) {
			ex.printStackTrace();
			DbUtils.rollback(conn);
		}finally {
			DbUtils.close(conn);
		}
	}
}
