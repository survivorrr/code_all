package ioc2;

public class A {
	private B b;
	public A(B b) {
		System.out.println("A(B)");
		this.b = b;
	}
	
	public A() {
		System.out.println("A()");
	}
	
	public void execute() {
		System.out.println("execute()");
	}
}
