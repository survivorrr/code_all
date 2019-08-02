package cn.itcast.demo01;

public class TimeTese {
	public static void main(String[] args) {
		long s = 0;;
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++)
		{
			System.out.println(i);
			
		}

		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
		
	}
}
