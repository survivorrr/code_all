package cn.itcast.demo02;

public class Tickets implements Runnable{
	private /*static*/ int tickets = 100;
//	private int num = 1;
	private Object obj = new Object();
	public void run(){
		while(true){
			synchronized_function();
		}
	}
	public /*static*/ synchronized void synchronized_function(){

			if(tickets>0){
				try{
					Thread.sleep(10);
				}catch(Exception ex){}
				
				System.out.println(Thread.currentThread().getName()+" 出售第"+ tickets-- +"张票" );

			}
	}
}
