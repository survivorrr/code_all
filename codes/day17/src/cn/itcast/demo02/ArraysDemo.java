package cn.itcast.demo02;

import java.util.Arrays;


public class ArraysDemo {
	public static void main(String[] args) {
		int[] arr = {575,46,75446,52,6,27,2564};
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		int index = Arrays.binarySearch(arr, 27);
		System.out.println(index);
	}
	
}
