package TreadDemo01;
/**
 * join():join��������ʹ���ø÷������߳̽�������״̬��ֱ���÷��������߳���ɹ����Ż������ø÷����̵߳�����״̬
 * join����һ��������ɶ���߳�֮���ͬ����������
 * @author Administrator
 *
 */
public class Thread_join {
	//��ʾͼƬ�Ƿ��������
	public static boolean isFinish=false;
	
	public static void main(String[] args) {
		
		final Thread download = new Thread() {
			public void run() {
				System.out.println("down:��ʼ����ͼƬ");
				for(int i=0;i<100;i++) {
					System.out.println("down:"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				System.out.println("down:ͼƬ�������");
				isFinish = true;
			}
		};
		download.start();
		
		Thread show = new Thread() {//�����ڲ��࣬û�����֣�ֻ֪������Thread��һ������
			public void run() {
				System.out.println("show����ʼ��ʾͼƬ");
				/**
				 * �ȵȴ�download��ͼƬ�������
				 */
				try {
					download.join();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				if(!isFinish) {
					throw new RuntimeException("ͼƬû���������");
				}
				System.out.println("show:ͼƬ��ʾ���");
			}
		};
		show.start();
	}
}
