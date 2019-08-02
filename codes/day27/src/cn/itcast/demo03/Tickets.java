package cn.itcast.demo03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tickets implements Runnable{
	private /*static*/ int tickets = 100;
//	private int num = 1;
//	private Object obj = new Object();
	
	//Lock�ӿڵ�ʵ����ReentrantLock����һ�����������������lock��unlock������ȡ�����ͷ���
	private Lock lock = new ReentrantLock();
	public void run(){
		while(true){
			lock.lock();
			if(tickets>0){
				try{
					Thread.sleep(10);
					System.out.println(Thread.currentThread().getName()+" ���۵�"+ tickets-- +"��Ʊ" );
				}catch(Exception ex){
					
				}finally{
					lock.unlock();
				}
				
				

			}
		}
	}
}
