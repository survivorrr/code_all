package TreadDemo01;
/**
 * ��̬������ͬ��
 * ��һ����̬������synchronized���κ���ô�÷�����Ϊͬ�����������ھ�̬���������࣬
 * ȫ�־�һ�ݣ�����ͬ���ľ�̬����һ������ͬ��Ч��(�Ͷ���û�й�ϵ),
 * synchronizedҲ�л�����(��������ͬһ������)
 * @author Administrator
 *
 */
public class Thread_staticsyn {
	public static void main(String[] args) {
		final Foo f1 = new Foo();
		final Foo f2 = new Foo();
		
		Thread t1 = new Thread() {
			public void run() {
				f1.dosome();//�Ͷ���û�й�ϵ
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				f2.dosome();
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Foo{
	public synchronized static void dosome() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+":"+"��������dosome()����");
			Thread.sleep(5000);
			System.out.println(t.getName()+":"+"dosome()�����������");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
