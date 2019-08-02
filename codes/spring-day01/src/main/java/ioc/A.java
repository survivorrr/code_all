package ioc;

public class A {//还需要在ioc.xml中做配置的，因为这个地方没有new一个对象，配置了之后就相当注入了一个对象进来
	private Impl b;
	public void setB(Impl b) {
		System.out.println("setB()");
		this.b = b;
	}
	 
	public A() {
		System.out.println("A()");
	}
	
	public void execute() {
		b.f1();
		System.out.println("execute()");
	}
}
