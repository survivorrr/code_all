package cn.itcast.demo04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
	public static void main(String[] args) {
		//使用工厂类Executors中的静态方法newFixedThreadPool()创建线程对象，返回ExecutorService接口的实现类
		ExecutorService ex =  Executors.newFixedThreadPool(3);
		System.out.println(ex);
		//用接口的实现类ex的方法submit()提交任务
		//将Runnable接口实现类对象传递
		ex.submit(new RunnableThreadPool());
		ex.submit(new RunnableThreadPool());
		ex.submit(new RunnableThreadPool());
		ex.submit(new RunnableThreadPool());
		
	}
}
