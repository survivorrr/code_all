package Annotation;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("«Î ‰»Î¿‡√˚:");
		String className = sc.nextLine();
		Class cls = Class.forName(className);
		Method[] array = cls.getDeclaredMethods();
		Object obj = cls.newInstance();
		for(Method method:array) {
			Demo ann = method.getAnnotation(Demo.class);
/*			System.out.println(method);
			System.out.println(ann);*/
			if(ann!=null) {
				method.invoke(obj);
			}
		}
	}
	
}
