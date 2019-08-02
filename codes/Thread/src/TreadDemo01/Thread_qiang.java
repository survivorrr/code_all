package TreadDemo01;
/**
 * 多线程并发访问同一资源时，就会形成抢的现象，由于线程切换时机不确定，可
 *  能导致执行的代码顺序混乱，严重时会导致系统瘫痪
 * @author Administrator
 *
 */
public class Thread_qiang {
	public static void main(String[] args) {
		final Table table = new Table();
		
		Thread t1 = new Thread() {
			public void run() {
				while(true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		
		
		Thread t2= new Thread() {
			public void run() {
				while(true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		t1.start();
		t2.start();
	}
	
}

class Table{
	//桌子上有20个豆子
	private int beans=20;
	/**
	 * 当一个方法被synchronized 修饰后，该方法为同步方法，即：多个线程不能同时进入方法内部执行，
	 * 对于成员方法而言，synchronized会在一个线程调用该方法时将该方法所属对象加锁，其他线程
	 * 在执行该方法时，由于执行该方法的线程没有释放锁，所以只能在方法外阻塞，知道持有方法锁的线程将方法执行完毕，
	 * 所以，解决多线程并发执行的安全问题的办法就是将“抢”变为“排队”
	 * @return
	 */
	public synchronized int getBean() {
		if(beans==0) {
			throw new RuntimeException("没有豆子了");
		}
		Thread.yield();
		return beans--;
	}
}
