package cn.itcast.demo04;

public class DiGuiDemo {
	public static void main(String[] args) {
		int s = getSum(100);
		System.out.println(s);
	}
	
	public static int getSum(int n){
		if(n == 1){
			return 1;
		}
		return n+getSum(n-1);
	}
}
