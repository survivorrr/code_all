package TreadDemo01;
/**
 * ��һ�ִ����̵߳ķ�ʽ���������㣺
 * 1.����java�ĵ��̳У���ô���̳���Thread�󣬾��޷��̳���������
 * 2.���ڼ̳�Thread����дrun�����涨���߳�ִ�е������⵼���߳���������һ����Ȼ����Ϲ�ϵ���������̵߳�����
 * @author Administrator
 *
 */
public class FirstThread{
	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		t1.start();//start�������ú��߳̽���runable״̬��һ����ȡcpuʱ�䣬run�����Զ�������
		t2.start();
	}
}
class MyThread1 extends Thread{
	public void run() {
		for(int i=0;i<10000;i++) {
			System.out.println("����˭����");
		}
	}
	
}
class MyThread2 extends Thread{
	public void run() {
		for(int i=0;i<10000;i++) {
			System.out.println("���ǲ�ˮ��ģ�");
		}
	}
	
}
