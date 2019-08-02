package TreadDemo01;
/**
 * 互斥锁：
 * synchronized 也叫互斥锁，即：使用synchronized修饰多段代码，只要他们的同步监视器对象相同，那么这几段代码间就是互斥关系，
 * 即：多个线程不能同时执行这些代码（同一段代码加了synchronized叫同步锁，不同代码加了synchronized叫互斥锁）
 * @author Administrator
 *
 */
public class Thread_huchi {
	public static void main(String[] args) {
		final Boo boo = new Boo();
		Thread t1 = new Thread() {
			public void run() {
				boo.methodA();
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				boo.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}

class Boo{
	public synchronized  void methodA() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+":"+"正在运行A方法");
			Thread.sleep(5000);
			System.out.println(t.getName()+":"+"A方法运行完毕");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public synchronized  void methodB() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+":"+"正在运行B方法");
			Thread.sleep(5000);
			System.out.println(t.getName()+":"+"B方法运行完毕");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
