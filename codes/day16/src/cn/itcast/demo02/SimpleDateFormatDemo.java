package cn.itcast.demo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
	public static void main(String[] args) throws Exception {
		
		Function_1();
		Function_2();
		
	}
	
	public static void Function_1()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年-MM月-dd日-HH时-mm分-ss秒");
		String date = sdf.format(new Date());
		System.out.println(date);
		
	}
	
	public static void Function_2() throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse("2018-8-27 19:22:50");
		System.out.println(date);
	}
}
