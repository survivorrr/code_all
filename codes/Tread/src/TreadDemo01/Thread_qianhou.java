package TreadDemo01;
/**
 * �ػ��̣߳��ֳƺ�̨�̣߳���һ�������е�����ǰ̨�̶߳�����ʱ�����̾�Ҫ�����������к�̨�߳����У���ô��̨�̻߳ᱻǿ�ƽ���
 * 
 * @author Administrator
 *
 */
public class Thread_qianhou {
	public static void main(String[] args) {
		Thread rose = new Thread() {
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("rose:let me go");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				System.out.println("���� ���� ��   ��..................");
				System.out.println("��ͨ");
			}
		};
		
		
		Thread jack = new Thread() {
			public void run() {
				while(true) {
					System.out.println("jack:you jump,i jump");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		//Ĭ�϶���ǰ̨�̣߳�����Ϊ�ػ��̣߳�������start֮ǰ����
		jack.setDaemon(true);
		
		rose.start();
		jack.start();
		
		System.out.println("main����������");
	}
}
