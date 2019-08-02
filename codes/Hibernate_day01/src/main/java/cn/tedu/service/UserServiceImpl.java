package cn.tedu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource private UserDao userDao;  //@Resource��tomcat�ṩ��ע�⣬�����Ч����û�е���tomcat�İ�
										//@Autowird��spring�ṩ��
	
	@Transactional
	public void deleteUsers(String... ids) {
		for(String id:ids) {
			User user = userDao.findUserById(id);
			if(user==null) {
				throw new RuntimeException("id����"+id);
			}
			userDao.deleteUser(user);
		}
	}

}
