package cn.itcast.demo01;

public class NullPointerException_Demo {
	public static void main(String[] args) {
		int[] arr = null;
		function(arr);
	}
	
	//����NullPointerException����дRuntimeException����������ʱ�쳣��
	//������Ҫ��try...catch ���� throws ���д����
	public static void function(int[] arr) {
		if(arr==null) {
			throw new NullPointerException("��ָ���쳣");
		}
	}
}
