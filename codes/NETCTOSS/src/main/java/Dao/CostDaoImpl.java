package Dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Utils.DbUtils;
import entity.Cost;

public class CostDaoImpl implements CostDao, Serializable {

	public List<Cost> findAll() {
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			String sql = "select * from cost_lzh order by id";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql);
			List<Cost> list = new ArrayList();
			while(rs.next()) {
				//Alt+Shift+M可以直接构造一个方法
				Cost c = new Cost();
				c.setCostId(rs.getInt("Id"));
				c.setName(rs.getString("name"));
				c.setBaseDuration(rs.getInt("base_Duration"));
				c.setBaseCost(rs.getDouble("base_Cost"));
				c.setUnitCost(rs.getDouble("unit_Cost"));
				c.setStatus(rs.getString("status"));
				c.setDescr(rs.getString("descr"));
				c.setCreatime(rs.getTimestamp("creatime"));
				c.setStartime(rs.getTimestamp("startime"));
				c.setCostType(rs.getString("cost_type"));
				list.add(c);
			}
			return list;
		}catch(Exception e) {
			//记录日志
			e.printStackTrace();
			throw new RuntimeException("查询失败",e);
		}finally {
			DbUtils.close(conn);
		}
	}
	//保存
	public void save(Cost c) {
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			String sql = "insert into cost_lzh values("
					+ "cost_seq_lzh1.nextval,?,?,?,?,1,?,sysdate,null,?)";
			PreparedStatement pstate = conn.prepareStatement(sql);
			pstate.setString(1, c.getName());
			/*setInt()/setDouble()不允许传入null，但实际业务中
			 * 这些字段确实有null的情况，表里也支持null，此时需要将他们
			 * 当做对象来处理，用setObject来解决*/
			pstate.setObject(2, c.getBaseDuration());
			pstate.setObject(3, c.getBaseCost());
			pstate.setObject(4, c.getUnitCost());
			pstate.setString(5, c.getStatus());
			pstate.setString(6, c.getCostType());
			pstate.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("增加员工失败",e);
		}finally {
			DbUtils.close(conn);
		}
	}
	//查询ID
	public Cost findById(int id) {
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			String sql = "select * from cost_lzh where id=?";
			PreparedStatement pstate = conn.prepareStatement(sql);
			pstate.setInt(1, id);
			ResultSet rs = pstate.executeQuery();
			Cost c = new Cost();
			if(rs.next()) {
				c.setCostId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setBaseDuration(rs.getInt("base_Duration"));
				c.setBaseCost(rs.getDouble("base_Cost"));
				c.setUnitCost(rs.getDouble("unit_Cost"));
				c.setStatus(rs.getString("status"));
				c.setDescr(rs.getString("descr"));
				c.setCreatime(rs.getTimestamp("creatime"));
				c.setStartime(rs.getTimestamp("startime"));
				c.setCostType(rs.getString("cost_Type"));	
			}
			return c;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询资费失败",e);
		}finally {
			DbUtils.close(conn);
		}
	}
	//修改数据
	public void update(Cost c) {
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			String sql = "update cost_lzh set name=?,cost_Type=?,base_Duration=?,"
					+ "base_Cost=?,unit_Cost=?,descr=? where id=?";
			conn.setAutoCommit(false);
			PreparedStatement pstate = conn.prepareStatement(sql);
			pstate.setString(1, c.getName());
			pstate.setString(2, c.getCostType());
			pstate.setObject(3, c.getBaseDuration());
			pstate.setObject(4, c.getBaseCost());
			pstate.setObject(5, c.getUnitCost());
			pstate.setString(6, c.getDescr());
			pstate.setInt(7, c.getCostId());
			pstate.executeUpdate();
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("修改失败",e);
		}finally {
			DbUtils.close(conn);
		}
	}
	//这个main函数就作用是为了测试
	public static void main(String[] args) {
		CostDao dao = new CostDaoImpl();
		List<Cost> list = dao.findAll();
		for(Cost c : list) {
			System.out.println(c.getCostId()+"  "+c.getName());
		}
	}
}
