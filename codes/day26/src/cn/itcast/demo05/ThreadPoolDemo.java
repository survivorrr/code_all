package cn.itcast.demo05;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {
	public static void main(String[] args) throws Exception {
		ExecutorService ex = Executors.newFixedThreadPool(2);
		Future<Integer> f1 =  ex.submit(new ThreadPoolCallable(100));
		Future<Integer> f2 =  ex.submit(new ThreadPoolCallable(200));
		System.out.println(f1.get());
		System.out.println(f2.get());
		ex.shutdown();
	}
}
