package cn.itcast.demo04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dayDemo_1 {
	public static void main(String[] args) throws Exception{
		function();
	}
	
	public static void function() throws Exception
	{
		Date today = new Date();
		long todayTime = today.getTime();
		System.out.println(todayTime);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date furture = sdf.parse("2018-08-30");
		long furtureTime = furture.getTime(); 
		System.out.println(furtureTime);
		
		long time = furtureTime-todayTime;
		
		System.out.println(time);
		System.out.println(time/(24*60*60*1000));
	}
}
