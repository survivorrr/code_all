package ZhiShu;

public class ZhiShu {
	public  static void main(String[] args) {
		int max = 0;
		int i = 1;
		int j;
		for(j=2;j<=999983;j++) {
			if(999983%j==0) {
				if(999983==j) {
					System.out.println("������");
					break;
				}else {
					System.out.println(j);
					System.out.println("��������");
					break;
				}
			}
		}	
	}
}
