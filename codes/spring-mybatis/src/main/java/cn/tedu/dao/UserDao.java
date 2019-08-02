package cn.tedu.dao;

import cn.tedu.entity.User;

public interface UserDao {
	public User findByName(String name);
}
