package cn.tedu.cloud_note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.cloud_note.dao.UserDao;
import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;

@Service("userService") //扫描的spring容器
@Transactional
public class UserServiceImpl implements UserService{
	@Resource private UserDao userDao;
	//登录
	public NoteResult<User> checkLogin(String name,String password){
		//接收结果数据
		NoteResult<User> result = new NoteResult<User>();
		User user = userDao.findByName(name);
		//检测用户名
		if(user==null) {
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		//检测密码
		String md5Password = NoteUtil.md5(password);
		if(!user.getCn_user_password().equals(md5Password)) {
			result.setStatus(2);
			result.setMsg("密码错误");
			return result;
		}
		//用户名和密码都正确
		result.setStatus(0);
		result.setMsg("登录成功");
		result.setData(user);
		return result;
	}
	
	
	//注册
	public NoteResult<Object> addUser(String name,String password,String nick){
		NoteResult<Object> result = new NoteResult<Object>();
		//用户检测
		User hasUser = userDao.findByName(name);
		if(hasUser!=null) {
			result.setStatus(1);
			result.setMsg("用户已经被占用");
			return result;
		}
		//添加用户
		User user = new User();
		user.setCn_user_name(name);
		user.setCn_user_password(NoteUtil.md5(password));
		user.setCn_user_nick(nick);
		user.setCn_user_id(NoteUtil.createId());//创建并设置id
		userDao.save(user);
		result.setStatus(0);
		result.setMsg("注册成功");
		return result;
	}
}







