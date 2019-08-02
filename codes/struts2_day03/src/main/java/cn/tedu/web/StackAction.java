package cn.tedu.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class StackAction {
	private String message;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	private Map<String,Object> map;
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String execute() {
		System.out.println("StackAction");
		message = "Hello World";
		map = new HashMap<String,Object>();
		map.put("name", "Tom");
		map.put("age", 20);
		map.put("user.address", "±±¾©");
		map.put("001", "¹·¹·");
		return "success";
	}
}
