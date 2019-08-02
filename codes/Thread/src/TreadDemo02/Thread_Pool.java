package TreadDemo02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池有两个作用：
 * 1.重用线程
 * 2.控制线程数量
 * 当我们的应用需要创建大量线程或者发现线程会频繁的创建和销毁时就应当考虑使用线程池来维护线程
 * @author Administrator
 *
 */
public class Thread_Pool {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		for(int i=0;i<5;i++) {
			Runnable runn = new Runnable() {
				public void run() {
					try {
						Thread t = Thread.currentThread();
						System.out.println(t+"正在运行任务");
						Thread.sleep(5000);
						System.out.println(t+"运行任务完成");
					}catch(Exception e) {
						System.out.println("线程被中断了");
					}
				}
			};
			threadPool.execute(runn);
			System.out.println("指派了一个任务给线程池");
		}
		threadPool.shutdownNow();
		System.out.println("停止线程池了");
	}
}
