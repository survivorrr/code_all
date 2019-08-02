package TreadDemo01;
/**
 * 第二种创建线程的方式：
 * 实现Runnable接口并重写run方法
 * @author Administrator
 *
 */
public class SecondThread {
	public static void main(String[] args) {
		//单独定义任务
		Runnable r1 = new MyRunnable1();
		Runnable r2 = new MyRunnable2();
		//可以重用线程，就是线程池的实现方式，当需要执行其他任务的时候，只需要在创建一个任务赋给线程就可以了
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}
}

class MyRunnable1 implements Runnable{
	public void run() {
		for(int i=0;i<10000;i++) {
			System.out.println("你是谁啊？");
		}
	}
	
}
class MyRunnable2 implements Runnable{
	public void run() {
		for(int i=0;i<10000;i++) {
			System.out.println("我是查水表的！");
		}
	}
	
}

