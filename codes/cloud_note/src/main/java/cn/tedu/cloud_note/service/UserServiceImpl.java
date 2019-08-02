package cn.tedu.cloud_note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.cloud_note.dao.UserDao;
import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;

@Service("userService") //ɨ���spring����
@Transactional
public class UserServiceImpl implements UserService{
	@Resource private UserDao userDao;
	//��¼
	public NoteResult<User> checkLogin(String name,String password){
		//���ս������
		NoteResult<User> result = new NoteResult<User>();
		User user = userDao.findByName(name);
		//����û���
		if(user==null) {
			result.setStatus(1);
			result.setMsg("�û���������");
			return result;
		}
		//�������
		String md5Password = NoteUtil.md5(password);
		if(!user.getCn_user_password().equals(md5Password)) {
			result.setStatus(2);
			result.setMsg("�������");
			return result;
		}
		//�û��������붼��ȷ
		result.setStatus(0);
		result.setMsg("��¼�ɹ�");
		result.setData(user);
		return result;
	}
	
	
	//ע��
	public NoteResult<Object> addUser(String name,String password,String nick){
		NoteResult<Object> result = new NoteResult<Object>();
		//�û����
		User hasUser = userDao.findByName(name);
		if(hasUser!=null) {
			result.setStatus(1);
			result.setMsg("�û��Ѿ���ռ��");
			return result;
		}
		//����û�
		User user = new User();
		user.setCn_user_name(name);
		user.setCn_user_password(NoteUtil.md5(password));
		user.setCn_user_nick(nick);
		user.setCn_user_id(NoteUtil.createId());//����������id
		userDao.save(user);
		result.setStatus(0);
		result.setMsg("ע��ɹ�");
		return result;
	}
}







