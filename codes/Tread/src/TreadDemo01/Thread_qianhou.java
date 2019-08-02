package TreadDemo01;
/**
 * 守护线程：又称后台线程，当一个进程中的所有前台线程都结束时，进程就要结束，若还有后台线程运行，那么后台线程会被强制结束
 * 
 * @author Administrator
 *
 */
public class Thread_qianhou {
	public static void main(String[] args) {
		Thread rose = new Thread() {
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("rose:let me go");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				System.out.println("啊啊 啊啊 啊   啊..................");
				System.out.println("噗通");
			}
		};
		
		
		Thread jack = new Thread() {
			public void run() {
				while(true) {
					System.out.println("jack:you jump,i jump");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		//默认都是前台线程，设置为守护线程，并且在start之前设置
		jack.setDaemon(true);
		
		rose.start();
		jack.start();
		
		System.out.println("main方法结束了");
	}
}
