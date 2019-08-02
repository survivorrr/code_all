package TreadDemo01;
/**
 * ���̲߳�������ͬһ��Դʱ���ͻ��γ��������������߳��л�ʱ����ȷ������
 *  �ܵ���ִ�еĴ���˳����ң�����ʱ�ᵼ��ϵͳ̱��
 * @author Administrator
 *
 */
public class Thread_qiang {
	public static void main(String[] args) {
		final Table table = new Table();
		
		Thread t1 = new Thread() {
			public void run() {
				while(true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		
		
		Thread t2= new Thread() {
			public void run() {
				while(true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		t1.start();
		t2.start();
	}
	
}

class Table{
	//��������20������
	private int beans=20;
	/**
	 * ��һ��������synchronized ���κ󣬸÷���Ϊͬ����������������̲߳���ͬʱ���뷽���ڲ�ִ�У�
	 * ���ڳ�Ա�������ԣ�synchronized����һ���̵߳��ø÷���ʱ���÷���������������������߳�
	 * ��ִ�и÷���ʱ������ִ�и÷������߳�û���ͷ���������ֻ���ڷ�����������֪�����з��������߳̽�����ִ����ϣ�
	 * ���ԣ�������̲߳���ִ�еİ�ȫ����İ취���ǽ���������Ϊ���Ŷӡ�
	 * @return
	 */
	public synchronized int getBean() {
		if(beans==0) {
			throw new RuntimeException("û�ж�����");
		}
		Thread.yield();
		return beans--;
	}
}
