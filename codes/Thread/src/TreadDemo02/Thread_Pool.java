package TreadDemo02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳����������ã�
 * 1.�����߳�
 * 2.�����߳�����
 * �����ǵ�Ӧ����Ҫ���������̻߳��߷����̻߳�Ƶ���Ĵ���������ʱ��Ӧ������ʹ���̳߳���ά���߳�
 * @author Administrator
 *
 */
public class Thread_Pool {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		for(int i=0;i<5;i++) {
			Runnable runn = new Runnable() {
				public void run() {
					try {
						Thread t = Thread.currentThread();
						System.out.println(t+"������������");
						Thread.sleep(5000);
						System.out.println(t+"�����������");
					}catch(Exception e) {
						System.out.println("�̱߳��ж���");
					}
				}
			};
			threadPool.execute(runn);
			System.out.println("ָ����һ��������̳߳�");
		}
		threadPool.shutdownNow();
		System.out.println("ֹͣ�̳߳���");
	}
}
