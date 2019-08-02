package TreadDemo01;
/**
 * join():join方法可以使调用该方法的线程进入阻塞状态，直到该方法所属线程完成工作才会解除调用该方法线程的阻塞状态
 * join方法一般用来完成多个线程之间的同步工作问题
 * @author Administrator
 *
 */
public class Thread_join {
	//表示图片是否下载完毕
	public static boolean isFinish=false;
	
	public static void main(String[] args) {
		
		final Thread download = new Thread() {
			public void run() {
				System.out.println("down:开始下载图片");
				for(int i=0;i<100;i++) {
					System.out.println("down:"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				System.out.println("down:图片下载完毕");
				isFinish = true;
			}
		};
		download.start();
		
		Thread show = new Thread() {//匿名内部类，没有名字，只知道它是Thread的一个子类
			public void run() {
				System.out.println("show：开始显示图片");
				/**
				 * 先等待download把图片下载完毕
				 */
				try {
					download.join();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				if(!isFinish) {
					throw new RuntimeException("图片没有下载完毕");
				}
				System.out.println("show:图片显示完毕");
			}
		};
		show.start();
	}
}
