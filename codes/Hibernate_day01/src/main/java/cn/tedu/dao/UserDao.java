package cn.tedu.dao;

import cn.tedu.entity.User;

public interface UserDao {
	int addUser(User user);
	int deleteUser(User user);
	int update(User user);
	User findUserById(String id);
}
