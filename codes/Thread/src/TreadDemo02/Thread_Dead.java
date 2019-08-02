package TreadDemo02;
/**
 * ����
 * @author Administrator
 *
 */
public class Thread_Dead {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		Thread t1 = new Thread(mt,"С��");
		Thread t2 = new Thread(mt,"С��");
		t1.start();
		t2.start();
	}
}

class MyThread implements Runnable{
	Object o1 = new Object();
	Object o2 = new Object();
	public void run() {
		String name = Thread.currentThread().getName();
		if(name.equals("С��")) {
			methodA();
		}else if(name.equals("С��")) {
			methodB();
		}
	}
		
	public void methodA() {
		synchronized(o1) {
			System.out.println("��ȡ����o1��,����ִ��С������߳�");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
		}
			System.out.println("˯���ˣ�׼����ȡo2�����");
			synchronized (o2) {
				System.out.println("��ȡ����o2��,ִ��С������߳����");
			}
		}
	}
		
	public void methodB() {
		synchronized(o2) {
			System.out.println("��ȡ����o2��,����ִ��С������߳�");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("˯���ˣ�׼����ȡo1�����");
			synchronized (o1) {
				System.out.println("��ȡ����o1��,ִ��С������߳����");
			}
		}
	}
}
	