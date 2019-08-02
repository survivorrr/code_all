package cn.itcast.demo01;

public class ExceptionDemo {
	public static void main(String[] args) throws Exception {
		int[] arr = {};
		int i = getArray(arr);
		System.out.println(i);
	}
	public static int getArray(int[] arr) throws Exception {
		if(arr == null){ 
			throw new NullPointerException("空指针异常");
		}
		if(arr.length == 0){
			throw new Exception("数组中无任何元素");
		}
		int i = arr[arr.length-1];
		return i*2;
	}
}
