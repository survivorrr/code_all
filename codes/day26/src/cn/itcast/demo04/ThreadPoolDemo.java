package cn.itcast.demo04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
	public static void main(String[] args) {
		//ʹ�ù�����Executors�еľ�̬����newFixedThreadPool()�����̶߳��󣬷���ExecutorService�ӿڵ�ʵ����
		ExecutorService ex =  Executors.newFixedThreadPool(3);
		System.out.println(ex);
		//�ýӿڵ�ʵ����ex�ķ���submit()�ύ����
		//��Runnable�ӿ�ʵ������󴫵�
		ex.submit(new RunnableThreadPool());
		ex.submit(new RunnableThreadPool());
		ex.submit(new RunnableThreadPool());
		ex.submit(new RunnableThreadPool());
		
	}
}
