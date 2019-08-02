package dao;
import java.util.List;

import entity.Emp;
public interface EmpDao {
	List<Emp> findAll();// 接口默认就是public
	void save(Emp e);
}
