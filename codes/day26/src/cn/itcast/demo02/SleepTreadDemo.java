package cn.itcast.demo02;

public class SleepTreadDemo {
	public static void main(String[] args) {
		subSleepThread sst = new subSleepThread();
		
		System.out.println(sst.getName());//用getName()得到sst线程的名字
		
		sst.start();
		System.out.println(Thread.currentThread().getName());
	}
}
