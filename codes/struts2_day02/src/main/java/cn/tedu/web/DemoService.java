package cn.tedu.web;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
	public String test() {
		//��ȡ����webAction���߳�
		Thread t = Thread.currentThread();
		System.out.println("webAction:"+t);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "service";
	}
}
