package TreadDemo01;
/**
 * ʹ�������ڲ�������ɷ�ʽһ�뷽ʽ�����̴߳���
 * @author Administrator
 *
 */
public class Thread_niming {
	public static void main(String[] args) {
		//��ʽһ
		Thread t1 = new Thread() {
			public void run() {
				for(int i=0;i<10000;i++) {
					System.out.println("����˭����");
				}
			}
		};
		t1.start();
		
		//��ʽ��
		Runnable run = new Runnable() {
			public void run() {
				for(int i=0;i<10000;i++) {
					System.out.println("���ǲ�ˮ��ģ�");
				}
			}
		};
		Thread t2 = new Thread(run);
		t2.start();
		
	}
}
