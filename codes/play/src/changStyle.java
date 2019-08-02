
public class changStyle {
	public static void main(String[] args) {
		int i = 97;
		char c = (char)i;//将int类型的数据赋值给char类型，即为向下转型
		System.out.println(c);
		
		char ch = 'b';
		int j = ch;//将char类型的数据赋值给int类型，即为向上转型
		double l = ch;//将char类型的数据赋值给double类型，即为向上转型
		System.out.println(j);
		System.out.println(l);
		
		char[] arr= {'1','2','3','4','5','6'};
		System.out.println(arr);
		
	}
}//向下需要强制转型 

/*1、基本数据的长数据变为短数据类型时
 * char  byte  short int long float double 
 * 2、父类转化为子类时
 * father f = new father();
 * son extends father
 * son s = new son();
 * f = s;
 * s = (son) f;
 * */
