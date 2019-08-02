package cn.tedu.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.tedu.entity.User;
@Repository("userDao")  //这个userDao其实就是bean的id名称
public class UserDaoImpl implements UserDao{
	
	@Resource 
	private HibernateTemplate hibernateTemplate;
	public int addUser(User user) {
		Object id=hibernateTemplate.save(user);
		if(id!=null) {
			return 1;
		}
		return 0;
	}

	public int deleteUser(User user) {
		hibernateTemplate.delete(user);
		return 1;
	}

	public int update(User user) {
		hibernateTemplate.update(user);
		return 1;
	}

	public User findUserById(String id) {
		return hibernateTemplate.get(User.class, id);
	}

}
