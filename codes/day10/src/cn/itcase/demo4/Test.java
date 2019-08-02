package cn.itcase.demo4;

public class Test {
	public static void main(String[] args) {
		JavaEE je = new JavaEE();
		NetWork net = new NetWork();
		
		je.setName("zhangsan");
		je.setID("0001");
		
		net.setName("lisi");
		net.setID("0008");
		
		je.getName();
		je.getID();
		
		net.getName();
		net.getID();
		
		je.work();
		net.work();
	}
}
