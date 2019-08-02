package cn.tedu.jdbc.day02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PoolThread {
	public static void main(String[] args) {
		Thread t1 = new ThreadDemo(5000);
		Thread t2 = new ThreadDemo(6000);
		Thread t3 = new ThreadDemo(1000);
		t1.start();
		t2.start();
		t3.start();
	}
}

class ThreadDemo extends Thread{
	int wait;
	public ThreadDemo(int wait) {
		this.wait= wait;
	}
	
	public void run() {
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			System.out.println(this.getName()+"获得连接:"+conn);
			Thread.sleep(wait);
			String sql = "select 'Hello' as a from dual";
			Statement stat = conn.createStatement();
			ResultSet set = stat.executeQuery(sql);
			while(set.next()) {
				System.out.println(set.getString("a"));
			}
			System.out.println(wait+"结束");
/*			set.close();
			stat.close();*/
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}finally {
			DbUtils.close(conn);
		}
	}
}
