package FatherAndSon;

public class Test {
	public static void main(String[] args) {
		Father fa = new Son();
		fa.eat();
		
		Father f = new Father();
		Son s = new Son();
	//�������ÿ���ָ��������󣬶��������ò���ָ�������
/*��ȷ*/ f = s;//��son���͵�ֵ��ֵ��father����Ϊ����ת��
		f.eat();
/*����	s = (Son)f;
		s.eat();*/
		
/*��ȷ*/ Father fr = new Son();
		Son sn = new Son();
		sn = (Son)fr;//ָ���������ĸ������ø����������ý�����ת�ͣ�Ҫǿ��ת����
		sn.eat();
	}
}
