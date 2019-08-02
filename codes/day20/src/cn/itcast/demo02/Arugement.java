package cn.itcast.demo02;

public class Arugement {
	public static void main(String[] args) {
		int sum = getsum(1,2,3,4);
		System.out.println(sum);
	}
	
	public static int getsum(int...a){
		int sum = 0;
		for(int i : a)
		{
			sum = sum+i;
		}
		return sum;
	}
}
