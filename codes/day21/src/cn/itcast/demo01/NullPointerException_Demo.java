package cn.itcast.demo01;

public class NullPointerException_Demo {
	public static void main(String[] args) {
		int[] arr = null;
		function(arr);
	}
	
	//这里NullPointerException或者写RuntimeException都属于运行时异常，
	//都不需要用try...catch 或者 throws 进行处理的
	public static void function(int[] arr) {
		if(arr==null) {
			throw new NullPointerException("空指针异常");
		}
	}
}
