package InnferClass;
/**
 * 匿名内部类的演示
 * @author Administrator
 *
 */
public class InnerClass_niming {
	public static void main(String[] args) {
		//1.创建了Inter2的一个子类，没有名字
		//2.为该子类创建了一个对象，引用叫o1
		//3.大括号中的为子类的类体
		Inter2 o1 = new Inter2(){
			
		};
		
		//1.“又”创建了Inter2的一个子类，没有名字
		//2.为该子类创建了一个对象，引用叫o2
		//3.大括号中的为子类的类体
		Inter2 o2 = new Inter2(){
			
		};
		
		final int num=5;
		//1.创建了Inter3的一个子类，没有名字
		//2.为该子类创建了一个对象，引用叫o3
		//3.大括号中的为子类的类体
		Inter3 o3 = new Inter3(){ 
			public void show() {
				System.out.println("showshow");
				System.out.println(num);
			}
		};
		o3.show();
	}
}

interface Inter3{
	public void show();
}

interface Inter2{
	
}
