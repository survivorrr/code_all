package FatherAndSon;

public class Test {
	public static void main(String[] args) {
		Father fa = new Son();
		fa.eat();
		
		Father f = new Father();
		Son s = new Son();
	//父类引用可以指向子类对象，而子类引用不能指向父类对象
/*正确*/ f = s;//将son类型的值赋值给father，即为向上转型
		f.eat();
/*错误	s = (Son)f;
		s.eat();*/
		
/*正确*/ Father fr = new Son();
		Son sn = new Son();
		sn = (Son)fr;//指向子类对象的父类引用赋给子类引用叫向下转型，要强制转换。
		sn.eat();
	}
}
