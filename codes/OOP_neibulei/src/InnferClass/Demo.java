package InnferClass;


public class Demo {

	public static void main(String[] args) {
		String s1 = new String("sa");
		String s2 = new String("sa");
		String s3 = new String("sa");
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		
		Car c1 = new Car("c1","red",12);//重写equals和hashCode输出的值才一样
		Car c2 = new Car("c1","red",12);
		Car c3 = new Car("c1","red",12);
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
		
		String s4 = "sa";
		String s5 = "sa";
		String s6 = null;
		System.out.println(s6.hashCode());//发生异常
/*		int a1 = 5;
		Integer a2 = new Integer(5);
		a2.hashCode();*/
		System.out.println(s4.hashCode());
		System.out.println(s5.hashCode());
	}
}
