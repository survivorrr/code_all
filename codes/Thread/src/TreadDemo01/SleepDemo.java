package TreadDemo01;
/**
 * �߳��ṩ�ľ�̬����sleep����ʹ���и÷������߳̽�������״ָ̬�����룬��ʱ���̻߳��Զ��ص�Runnable״̬
 * @author Administrator
 *
 */
public class SleepDemo {
	public static void main(String[] args) {
		while(true) {
			System.out.println("���");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {//�ж�һ������sleep���̣߳��ͻᷢ��InterruptedException
				e.printStackTrace();
			}
		}
	}
}
