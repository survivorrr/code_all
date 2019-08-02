package cn.itcast.demo03;

import java.util.Calendar;

public class CalendarDemo {
	public static void main(String[] args) {
		function_1();
	}
	
	public static void function()
	{
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+"年"+month+"月 "+day+"日");
	}
	
	
	public static void function_1()
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2019);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+"年"+month+"月 "+day+"日");
	}
}
