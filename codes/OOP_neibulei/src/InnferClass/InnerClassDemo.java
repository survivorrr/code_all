package InnferClass;
/**
 * ��Ա�ڲ������ʾ
 * @author Administrator
 *
 */
public class InnerClassDemo {
	public static void main(String[] args) {
		Mama m = new Mama();
	//	Baby b = new Baby();  //��������ڲ�����ⲻ�߱��ɼ���
	}
}

class Mama{//�ⲿ��
	private String name;
	Baby createBaby() {
		return new Baby();//�ڲ�����ⲿ����˵�ɼ�
	}
	class Baby{//�ڲ���
		public void showMamaName() {
			System.out.println(name);
			System.out.println(Mama.this.name);//������Ч��һ��
			//System.out.println(this.name);//�������
		}
	}
}
