package InnferClass;

public class A {
	public static void main(String[] args) {
		Integer[] in = new Integer[5];
		Integer i = new Integer(6);
	
		System.out.println(in[0]);
		System.out.println(in);
		System.out.println(i);
		in[0] = i;
		System.out.println(in[0].getClass());
		
	}
}
