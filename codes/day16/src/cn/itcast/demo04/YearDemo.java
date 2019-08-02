package cn.itcast.demo04;

import java.util.Calendar;
import java.util.Date;

public class YearDemo {
	public static void main(String[] args) {
		function();
	}
	
	public static void function()
	{
		Calendar c = Calendar.getInstance();
		c.set(2000, 2, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		int day = c.get(c.DAY_OF_MONTH);
		System.out.println(day);
		
		Date date = c.getTime();
		System.out.println(date);
	}
}
