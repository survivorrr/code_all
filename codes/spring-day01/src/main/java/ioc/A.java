package ioc;

public class A {//����Ҫ��ioc.xml�������õģ���Ϊ����ط�û��newһ������������֮����൱ע����һ���������
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
