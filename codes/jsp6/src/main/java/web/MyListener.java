package web;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyListener implements ServletRequestListener,
									ServletRequestAttributeListener{
	//tomcat����requestǰ�Զ����ô˷���
	public void requestDestroyed(ServletRequestEvent e) {
		System.out.println("����request");
	}
	//tomcat����request���Զ����ô˷���
	public void requestInitialized(ServletRequestEvent e) {
		System.out.println("����request");
		System.out.println(e.getServletRequest());
	}
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("��request�����һ��ֵ");
	}
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
	}
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
	}

}
