package cn.tedu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.entity.User;

@Controller
public class JsonController {
	@RequestMapping("/json1.do")   //匹配请求
	@ResponseBody           //调用jackson
	public User loadUser() {
		User user = new User(1,"Jack","20");
		return user;
	}
	@RequestMapping("/json2.do")
	@ResponseBody
	public List<User> loadUsers(){
		List<User> list = new ArrayList<User>();
		User user1 = new User(1,"苍老师","18");
		User user2 = new User(2,"二蛋","88");
		
		list.add(user1);
		list.add(user2);
		return list;
	}
	@RequestMapping("/json3.do")
	@ResponseBody
	public Map<String,Object> loadData(){
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("id", 1);
		data.put("name", "狗蛋儿");
		return data;
	}
}
