package cn.tedu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource private UserDao userDao;  //@Resource是tomcat提供的注解，这个无效代表没有导入tomcat的包
										//@Autowird是spring提供的
	
	@Transactional
	public void deleteUsers(String... ids) {
		for(String id:ids) {
			User user = userDao.findUserById(id);
			if(user==null) {
				throw new RuntimeException("id错误"+id);
			}
			userDao.deleteUser(user);
		}
	}

}
