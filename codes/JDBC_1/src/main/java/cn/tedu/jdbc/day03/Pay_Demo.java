package cn.tedu.jdbc.day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import cn.tedu.jdbc.day02.DbUtils;

public class Pay_Demo {
	public static void main(String[] args) {
		pay(2,3,10000);//��?���˻���?ԪǮ��?���˻�
	
	}
	
	public static void pay(int from,int to,double money){
		String sql1 = "update a_account set balance=balance+? where id=?";
		String sql2 = "select * from a_account where id=?";
//		String sql3 = "select name from a_account where id=?";
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			//ȡ���Զ��ύ
			conn.setAutoCommit(false);
			PreparedStatement pstate = conn.prepareStatement(sql1);
			//��Ǯ
			pstate.setDouble(1, -money);
			pstate.setInt(2, from);
			int n = pstate.executeUpdate();
			if(n!=1) {
				throw new Exception("�۴���");
			}
			//����
			pstate.setDouble(1, money);
			pstate.setInt(2, to);
			n = pstate.executeUpdate();
			if(n!=1) {
				throw new Exception("�Ӵ���");
			}
			//�ر�ԭ����ִ��ƽ̨
			pstate.close();
			//���
			pstate = conn.prepareStatement(sql2);
			pstate.setInt(1, from);
			ResultSet rs = pstate.executeQuery();
/*			ResultSetMetaData rsmd = rs.getMetaData();
			int m = rsmd.getColumnCount();
			System.out.println(m);*/
			while(rs.next()) {
			/*	double balance = rs.getDouble(1);//sql��������ֻ��ѯ��id=?ʱ��balance
			             	                                                      ��ֻ��һ��һ�У���������Ϊ2ʱ���������������*/
				double balance = rs.getDouble("balance");
				if(balance<0) {
					throw new Exception(rs.getString(2)+"�˺�����"+money);
				}
			}
			
/*			while(rs.next()) {
				
				double balance = rs.getDouble(1);//sql��������ֻ��ѯ��id=?ʱ��balance
				��ֻ��һ��һ�У���������Ϊ2ʱ���������������
				double balance = rs.getDouble("balance");
				if(balance<0) {
					pstate.close();
					pstate = conn.prepareStatement(sql3);
					pstate.setInt(1, from);
					rs = pstate.executeQuery();
					while(rs.next()) {
						throw new Exception(rs.getString(1)+"�˺�����"+money);
					}
				}
			}*/
			
			//�ֶ��ύ
			conn.commit();
			System.out.println("���"+money+"Ԫ�ɹ����뵽���ݿ��в�ѯ!!!");
		}catch(Exception ex) {
			ex.printStackTrace();
			DbUtils.rollback(conn);
		}finally {
			DbUtils.close(conn);
		}
	}
}
