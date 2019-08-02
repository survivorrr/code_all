package cn.itcast.demo02;

import java.io.IOException;

public class subSleepThread extends Thread{
	
	public void run(){
//		System.out.println(Thread.currentThread().getName());
		for(int i=0;i<5;i++){
			try{
				sleep(1000);
			}catch(Exception ex){

			}
			System.out.println(i);
		}
	}

}
