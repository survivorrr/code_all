package cn.itcast.demo04;

public class FBNQDemo {
	public static void main(String[] args) {
		int number = FBNQFunction(12);
		System.out.println(number);
	}
	public static int FBNQFunction(int month){
		if(month == 1){
			return 1;
		}
		if(month == 2){
			return 1;
		}
		return FBNQFunction(month-1)+FBNQFunction(month-2);
	}
}
