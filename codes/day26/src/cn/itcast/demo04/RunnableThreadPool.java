package cn.itcast.demo04;

public class RunnableThreadPool implements Runnable{
	public void run(){
		System.out.println(Thread.currentThread().getName()+" �߳������ύ����");
	}
}
