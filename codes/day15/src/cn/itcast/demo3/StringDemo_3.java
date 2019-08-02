package cn.itcast.demo3;

public class StringDemo_3 {
	public static void main(String[] args)
	{
		String [] arr = {"1","2","3","4","5","6","7"};
		String [] arr1 = toString(arr);
		for(int i=0;i<arr1.length;i++)
		{
			
			if(i>0 && i<arr1.length-2)
			{
				System.out.print(arr1[i]);
				System.out.print(",");
				
			}
			else 
			{
				System.out.print(arr1[i]);
			}
	}
			
	}
	public static String[] toString(String [] arr)
	{
		String[] arr1 = new String[arr.length+2];
		arr1[0]="[";
		for(int i=0;i<arr.length;i++)
		{
				arr1[i+1] = arr[i];	
		}
		arr1[arr.length+1] = "]";
		return arr1;
	}
}
