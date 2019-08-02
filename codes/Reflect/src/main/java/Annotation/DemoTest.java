package Annotation;

import org.eclipse.jdt.internal.compiler.ast.SynchronizedStatement;

public class DemoTest {
	@Demo
	public void demo1() {
		System.out.println("demo1()");
	}
	
	@Demo
	public void demo2() {
		System.out.println("demo2()");
	}
	
	public void demo3() {
		System.out.println("demo2()");
	}
}
