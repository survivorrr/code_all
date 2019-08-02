package cn.itcase.demo2;

public class Person_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p = new Person();
		p.setAge(24);
		p.setName("ÁÎ³¯êÍ");
		
		p.speak();
	
		
		System.out.println(p.getAge()+p.getName());
	}

}
