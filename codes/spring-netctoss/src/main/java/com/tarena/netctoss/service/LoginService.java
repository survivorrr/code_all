package com.tarena.netctoss.service;

import com.tarena.netctoss.entity.Admin;
/*
 * ҵ���ӿ�
 * */
public interface LoginService {
	public Admin checkLogin(String adminCode, String pwd);
}
