
public class changStyle {
	public static void main(String[] args) {
		int i = 97;
		char c = (char)i;//��int���͵����ݸ�ֵ��char���ͣ���Ϊ����ת��
		System.out.println(c);
		
		char ch = 'b';
		int j = ch;//��char���͵����ݸ�ֵ��int���ͣ���Ϊ����ת��
		double l = ch;//��char���͵����ݸ�ֵ��double���ͣ���Ϊ����ת��
		System.out.println(j);
		System.out.println(l);
		
		char[] arr= {'1','2','3','4','5','6'};
		System.out.println(arr);
		
	}
}//������Ҫǿ��ת�� 

/*1���������ݵĳ����ݱ�Ϊ����������ʱ
 * char  byte  short int long float double 
 * 2������ת��Ϊ����ʱ
 * father f = new father();
 * son extends father
 * son s = new son();
 * f = s;
 * s = (son) f;
 * */
