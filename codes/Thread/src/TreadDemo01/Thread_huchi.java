package TreadDemo01;
/**
 * ��������
 * synchronized Ҳ�л�����������ʹ��synchronized���ζ�δ��룬ֻҪ���ǵ�ͬ��������������ͬ����ô�⼸�δ������ǻ����ϵ��
 * ��������̲߳���ͬʱִ����Щ���루ͬһ�δ������synchronized��ͬ��������ͬ�������synchronized�л�������
 * @author Administrator
 *
 */
public class Thread_huchi {
	public static void main(String[] args) {
		final Boo boo = new Boo();
		Thread t1 = new Thread() {
			public void run() {
				boo.methodA();
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				boo.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}

class Boo{
	public synchronized  void methodA() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+":"+"��������A����");
			Thread.sleep(5000);
			System.out.println(t.getName()+":"+"A�����������");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public synchronized  void methodB() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+":"+"��������B����");
			Thread.sleep(5000);
			System.out.println(t.getName()+":"+"B�����������");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
