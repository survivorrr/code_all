package cn.itcast.demo2;

public class StringDemo_1 {
		public static void main(String[] args) {
			int count = getStringCount("javanihjavaaojavagljdslgjava","java");
			System.out.println(count);
		}
		
		public static int getStringCount(String str,String key)
		{
			int count = 0;
			int index = 0;
			while((index = str.indexOf(key)) != -1)
			{
				count++;
				str = str.substring(index+key.length());
			}
			return count;
		}
}
