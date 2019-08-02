package TreadDemo01;
/**
 * 使用匿名内部类来完成方式一与方式二的线程创建
 * @author Administrator
 *
 */
public class Thread_niming {
	public static void main(String[] args) {
		//方式一
		Thread t1 = new Thread() {
			public void run() {
				for(int i=0;i<10000;i++) {
					System.out.println("你是谁啊？");
				}
			}
		};
		t1.start();
		
		//方式二
		Runnable run = new Runnable() {
			public void run() {
				for(int i=0;i<10000;i++) {
					System.out.println("我是查水表的！");
				}
			}
		};
		Thread t2 = new Thread(run);
		t2.start();
		
	}
}
