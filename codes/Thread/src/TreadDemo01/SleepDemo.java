package TreadDemo01;
/**
 * 线程提供的静态方法sleep可以使运行该方法的线程进入阻塞状态指定毫秒，超时后线程会自动回到Runnable状态
 * @author Administrator
 *
 */
public class SleepDemo {
	public static void main(String[] args) {
		while(true) {
			System.out.println("你好");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {//中断一个正在sleep的线程，就会发生InterruptedException
				e.printStackTrace();
			}
		}
	}
}
