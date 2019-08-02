package com.tarena.netctoss.dao;



import com.tarena.netctoss.entity.Admin;

public interface AdminDao {
	public Admin findByAdminCode(String adminCode);
}
