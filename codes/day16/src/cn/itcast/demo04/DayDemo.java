package cn.itcast.demo04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DayDemo {
	public static void main(String[] args) throws Exception {
		function();
	}
	
	public static void function() throws Exception
	{
		while(true)
		{
			System.out.println("请输入你的出生日期，格式为:yyyy-MM-dd");
			Scanner birthday = new Scanner(System.in);
			String birthdayString = birthday.next();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date birthdayDate = sdf.parse(birthdayString);
			long birthdayTime = birthdayDate.getTime();
			
			Date todaydate = new Date();
			long todaydateTime = todaydate.getTime();
			
			long Time = todaydateTime-birthdayTime;
			if(Time < 0)
			{
				System.out.println("输入错误,请重新输入");
				
			}
			else
			{
				System.out.println(Time/1000/60/60/24);
				return;
			}
		}

		
//		System.out.println(Time/(124*60*60*1000));
//		System.out.println(time);
		
//		System.out.println(System.currentTimeMillis());
		
	}

}
