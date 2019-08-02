package TreadDemo01;
/**
 * 静态方法的同步
 * 当一个静态方法被synchronized修饰后，那么该方法即为同步方法，由于静态方法从属类，
 * 全局就一份，所以同步的静态方法一定具有同步效果(和对象没有关系),
 * synchronized也叫互斥锁(加锁的是同一个对象)
 * @author Administrator
 *
 */
public class Thread_staticsyn {
	public static void main(String[] args) {
		final Foo f1 = new Foo();
		final Foo f2 = new Foo();
		
		Thread t1 = new Thread() {
			public void run() {
				f1.dosome();//和对象没有关系
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				f2.dosome();
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Foo{
	public synchronized static void dosome() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+":"+"正在运行dosome()方法");
			Thread.sleep(5000);
			System.out.println(t.getName()+":"+"dosome()方法运行完毕");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
