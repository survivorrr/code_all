package TreadDemo02;
/**
 * 死锁
 * @author Administrator
 *
 */
public class Thread_Dead {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		Thread t1 = new Thread(mt,"小红");
		Thread t2 = new Thread(mt,"小明");
		t1.start();
		t2.start();
	}
}

class MyThread implements Runnable{
	Object o1 = new Object();
	Object o2 = new Object();
	public void run() {
		String name = Thread.currentThread().getName();
		if(name.equals("小红")) {
			methodA();
		}else if(name.equals("小明")) {
			methodB();
		}
	}
		
	public void methodA() {
		synchronized(o1) {
			System.out.println("获取到了o1锁,正在执行小红这个线程");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
		}
			System.out.println("睡醒了，准备获取o2这个锁");
			synchronized (o2) {
				System.out.println("获取到了o2锁,执行小红这个线程完毕");
			}
		}
	}
		
	public void methodB() {
		synchronized(o2) {
			System.out.println("获取到了o2锁,正在执行小明这个线程");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("睡醒了，准备获取o1这个锁");
			synchronized (o1) {
				System.out.println("获取到了o1锁,执行小明这个线程完毕");
			}
		}
	}
}
	