package cn.itcast.demo01;

public class ExceptionDemo {
	public static void main(String[] args) throws Exception {
		int[] arr = {};
		int i = getArray(arr);
		System.out.println(i);
	}
	public static int getArray(int[] arr) throws Exception {
		if(arr == null){ 
			throw new NullPointerException("��ָ���쳣");
		}
		if(arr.length == 0){
			throw new Exception("���������κ�Ԫ��");
		}
		int i = arr[arr.length-1];
		return i*2;
	}
}
