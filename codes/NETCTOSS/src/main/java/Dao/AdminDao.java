package Dao;

import entity.Admin;

public interface AdminDao {
	Admin findByCode(String code);
}
