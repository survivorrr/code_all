package cn.itcast.demo4;

public class TestArugements {
	public static void main(String[] args)
	{
		Student s = new Student();
		noSmoking(s);
	}
	public static void noSmoking(Smoking s)
	{
		s.smoking();
	}
}
