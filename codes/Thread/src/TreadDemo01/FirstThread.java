package TreadDemo01;
/**
 * 第一种创建线程的方式有两个不足：
 * 1.由于java的单继承，那么当继承了Thread后，就无法继承其它的类
 * 2.由于继承Thread后重写run方法规定了线程执行的任务，这导致线程与任务有一个必然的耦合关系，不利于线程的重用
 * @author Administrator
 *
 */
public class FirstThread{
	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		t1.start();//start方法调用后，线程进入runable状态，一旦获取cpu时间，run方法自动被调用
		t2.start();
	}
}
class MyThread1 extends Thread{
	public void run() {
		for(int i=0;i<10000;i++) {
			System.out.println("你是谁啊？");
		}
	}
	
}
class MyThread2 extends Thread{
	public void run() {
		for(int i=0;i<10000;i++) {
			System.out.println("我是查水表的！");
		}
	}
	
}
