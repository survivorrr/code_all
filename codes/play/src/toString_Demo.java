
public class toString_Demo {
	public static void main(String[] args) {
		Person p = new Person();
		System.out.println(p);
		System.out.println(p.toString());
	}
}
class Person {
		String name = "QQQ";
		String sex = "ÄÐ";
		int age = 23;
		public String toString() {
			return name+" "+sex+" "+age;
		}
}