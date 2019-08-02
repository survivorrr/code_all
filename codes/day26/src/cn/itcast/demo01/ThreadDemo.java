package cn.itcast.demo01;

public class ThreadDemo {
	public static void main(String[] args) {
		subThread st = new subThread();
		st.start();
		for(int i=0;i<50;i++){
			System.out.println("main..."+i);
		}
	}
}
