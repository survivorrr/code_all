package demo;

public class Test {
	public static void main(String[] args) throws Exception{
		ClassPathXmlApplicationContext cpxac = 
			new ClassPathXmlApplicationContext("spring-context.xml");
		Foo foo = (Foo)cpxac.getBean("foo");
		Foo foo1 = cpxac.getBean("foo", Foo.class);
//		Class<demo.Foo> cls = Foo.class;
		System.out.println(foo);
		System.out.println(foo1);
	}
}
