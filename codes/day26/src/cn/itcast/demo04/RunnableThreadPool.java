package cn.itcast.demo04;

public class RunnableThreadPool implements Runnable{
	public void run(){
		System.out.println(Thread.currentThread().getName()+" 线程正在提交任务");
	}
}
