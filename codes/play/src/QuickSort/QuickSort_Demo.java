package QuickSort;

public class QuickSort_Demo {
	public static void quickSort(int[] array,int start,int end) {
		if(array==null) {
			return;
		}
		int flag = array[start];
		int first = start;
		int last = end;
		int temp;
		while(start < end) {
			while(array[end] > flag) {
				end--;
			}
			if(array[end] < flag) {
				temp=array[end];
				array[end]=flag;
				array[start]=temp;
			}
			while(array[start]<flag) {
				start++;
			}
			if(array[start]>flag) {
				temp = array[start];
				array[start]=flag;
				array[end]=temp;
			}
		}
		if(start>first) {
			quickSort(array,first,start-1);
		}
		if(end<last) {
			quickSort(array,end+1,last);
		}
	}
}


