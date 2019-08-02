package ioc;

public class B implements Impl{
	public B() {
		System.out.println("B()");
	}
	
	public void f1() {
		System.out.println("B's f1()");
	}
}
