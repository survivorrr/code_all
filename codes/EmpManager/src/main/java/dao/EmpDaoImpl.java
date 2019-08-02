package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import entity.Emp;

public class EmpDaoImpl implements EmpDao, Serializable {
	
		//模拟实现查询所有员工
	//这个方法正常来讲要用JDBC创立连接，写sql，执行sql，返回结果集
	//遍历结果集，把每一条数据封装成一个Emp，存到list中再返回。
	public List<Emp> findAll() {
		List<Emp> list = new ArrayList<Emp>();
		Emp e1 = new Emp();
		e1.setEmpno(1);
		e1.setEname("唐僧");
		e1.setJob("领导");
		e1.setSal(9000.0);
		list.add(e1);
		
		Emp e2 = new Emp();
		e2.setEmpno(2);
		e2.setEname("悟空");
		e2.setJob("保镖");
		e2.setSal(4000.0);
		list.add(e2);
		
		Emp e3 = new Emp();
		e3.setEmpno(3);
		e3.setEname("八戒");
		e3.setJob("保镖");
		e3.setSal(6000.0);
		list.add(e3);
		
		return list;
	}
	public void save(Emp e) {
		System.out.println("增加员工："+e.getEname());
		//这个输出在控制台，而不是返回的页面
	}
}
