package com.tarena.netctoss.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.netctoss.dao.AdminDao;
import com.tarena.netctoss.entity.Admin;
/*
 * ҵ���ʵ��
 * */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Resource(name="adminDao")
	private AdminDao dao;
	public Admin checkLogin(String adminCode, String pwd) {
		Admin admin = null;
		admin = dao.findByAdminCode(adminCode);
		if(admin==null) {
			//�˺Ų����ڣ��׳�һ��Ӧ���쳣���û�����������쳣��
			throw new ApplicationException("�˺Ų�����");
		}
		if(!admin.getPassword().equals(pwd)) {
			//�������
			throw new ApplicationException("�������");
		}
		//��¼�ɹ�
		return admin;
	}
}
