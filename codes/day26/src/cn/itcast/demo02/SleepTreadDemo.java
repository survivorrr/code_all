package cn.itcast.demo02;

public class SleepTreadDemo {
	public static void main(String[] args) {
		subSleepThread sst = new subSleepThread();
		
		System.out.println(sst.getName());//��getName()�õ�sst�̵߳�����
		
		sst.start();
		System.out.println(Thread.currentThread().getName());
	}
}
