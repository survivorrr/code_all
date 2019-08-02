package Test;

import java.lang.reflect.Method;
import java.util.Scanner;

public class TestFoo {
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("«Î ‰»Î¿‡√˚£∫");
		String classname = sc.nextLine();
		Class cls = Class.forName(classname);
		Object obj = cls.newInstance();
		Method[] methods = cls.getDeclaredMethods();
		for(Method method:methods) {
			System.out.println(method);
		}
		
	}
}
