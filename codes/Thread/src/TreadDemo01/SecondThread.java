package TreadDemo01;
/**
 * �ڶ��ִ����̵߳ķ�ʽ��
 * ʵ��Runnable�ӿڲ���дrun����
 * @author Administrator
 *
 */
public class SecondThread {
	public static void main(String[] args) {
		//������������
		Runnable r1 = new MyRunnable1();
		Runnable r2 = new MyRunnable2();
		//���������̣߳������̳߳ص�ʵ�ַ�ʽ������Ҫִ�����������ʱ��ֻ��Ҫ�ڴ���һ�����񸳸��߳̾Ϳ�����
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}
}

class MyRunnable1 implements Runnable{
	public void run() {
		for(int i=0;i<10000;i++) {
			System.out.println("����˭����");
		}
	}
	
}
class MyRunnable2 implements Runnable{
	public void run() {
		for(int i=0;i<10000;i++) {
			System.out.println("���ǲ�ˮ��ģ�");
		}
	}
	
}

