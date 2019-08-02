package cn.tedu.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class RedirectAction {
	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public String execute() {
		if(type==0) {
			return "doc";
		}else {
			return "photo";
		}
	}
}
