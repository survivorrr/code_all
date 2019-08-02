package ZhiShu;

public class ZhiShu_Max {
	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		int max = 0;
		int i=0;
		while(i<1000000) {
			for(int j=2;j<=i;j++) {
				if(i%j==0) {
					if(j==i) {
						max=i;
					}
					break;
				}
			}
			i++;
		}
		long b = System.currentTimeMillis();
		System.out.println(max);
		System.out.println((b-a)/10000f+"Ãë");
		
	}
}
