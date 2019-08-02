package cn.itcast.demo05;

import java.util.concurrent.Callable;

public class ThreadPoolCallable implements Callable<Integer>{
	int sum = 0;
	int a;
	public ThreadPoolCallable(int a){
		this.a = a;
	}
	public Integer call(){
		for(int i=1;i<=a;i++){
			sum = sum + i;
		}
		return sum;
	}
}
