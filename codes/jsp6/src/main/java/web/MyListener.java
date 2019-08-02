package web;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyListener implements ServletRequestListener,
									ServletRequestAttributeListener{
	//tomcat销毁request前自动调用此方法
	public void requestDestroyed(ServletRequestEvent e) {
		System.out.println("销毁request");
	}
	//tomcat创建request后自动调用此方法
	public void requestInitialized(ServletRequestEvent e) {
		System.out.println("创建request");
		System.out.println(e.getServletRequest());
	}
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("向request内添加一个值");
	}
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
	}
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
	}

}
