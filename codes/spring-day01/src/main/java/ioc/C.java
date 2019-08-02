package ioc;

public class C implements Impl{
	public C() {
		System.out.println("C()");
	}
	
	public void f1() {
		System.out.println("C's f1()");
	}
}
