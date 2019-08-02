package ZhiShu;

public class star {
	public static void main(String[] args) {
		int count = method(4);
		System.out.println(count);
	}
	public static int method(int n) {
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		if(n>1&&n<=20) {
			return method(n-1)+method(n-2);
		}
		return 0;
	}
}
