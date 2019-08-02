package cn.itcast.demo04;

public class DeadLockDemo {
	public static void main(String[] args) {
		
		DeadLock t = new DeadLock();
		Thread t0 = new Thread(t);
		Thread t1 = new Thread(t);
		t0.start();
		t1.start();
	}
}
