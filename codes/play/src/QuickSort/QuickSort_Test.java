package QuickSort;

public class QuickSort_Test {
	public static void main(String[] args) {
		int[] array = {78,532,643,364,2345,2,0,5};
		int start=0;
		int end=array.length-1;
		QuickSort_Demo qs = new QuickSort_Demo();
		qs.quickSort(array,start,end);
		for(Integer i:array) {
			System.out.println(i);
		}
	}
}
