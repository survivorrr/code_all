package cn.itcast.demo03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tickets implements Runnable{
	private /*static*/ int tickets = 100;
//	private int num = 1;
//	private Object obj = new Object();
	
	//Lock接口的实现类ReentrantLock创建一个对象，这个对象条用lock和unlock方法获取锁和释放锁
	private Lock lock = new ReentrantLock();
	public void run(){
		while(true){
			lock.lock();
			if(tickets>0){
				try{
					Thread.sleep(10);
					System.out.println(Thread.currentThread().getName()+" 出售第"+ tickets-- +"张票" );
				}catch(Exception ex){
					
				}finally{
					lock.unlock();
				}
				
				

			}
		}
	}
}
