package AddrTest;

public class addr_demo {
	public static void main(String[] args) {
		String str1="abc";
		String str2=str1;//���൱��String str2="abc";
		System.out.println(str1==str2);
		str2="dfg";//�ڳ�����û��dfg������Ҫ���¿���һ���ڴ��arc��str�ͱ�ɴ��dfg�ĵ�ַ��
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println();
		String str3 = new String("bcd");
		String str4 = new String("hjk");
		str4=str3;
		System.out.println(str3);
		System.out.println(str4);
		System.out.println(str3==str4);
		System.out.println();
		
		Person p1 = new Person(10);
		Person p2 = new Person(20);
		p2 = p1;
	//	p2.setAge(20);
		System.out.println(p1.getAge());
		System.out.println(p2.getAge());
		System.out.println(p1==p2);	
	}
}
