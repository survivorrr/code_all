package test.dao;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloud_note.dao.EmpDao;
import cn.tedu.cloud_note.entity.Emp;
import test.TestBase;

public class TestEmpDao extends TestBase{
	private EmpDao empDao;
	@Before
	public void init() {
		empDao = super.getContext().getBean("empDao",EmpDao.class);
		
	}
	
	@Test
	public void test1() {
		Emp emp = new Emp();
		emp.setName("zhangfei");
		emp.setAge(88);
		empDao.save(emp);
		System.out.println(emp);
	}
	
	@Test
	public void test2() {
		Emp emp = new Emp();
		emp.setName("zhangfei");
		emp.setAge(88);
		empDao.save(emp);
		int id=emp.getId();   //int id = null;这句话包报错，不能int id = null; 但是可以Integer id = null;
		System.out.println("刚插入的id:"+id);
	}
}
