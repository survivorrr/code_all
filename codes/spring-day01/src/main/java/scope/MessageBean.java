package scope;

public class MessageBean {
	public MessageBean() {
		System.out.println("MessageBean()");
	}
	
	public void init() {
		System.out.println("init()");
	}
	public void sendMsg() {
		System.out.println("sendMessage()");
	}
	public void destroy() {
		System.out.println("destroy()");
	}
}
