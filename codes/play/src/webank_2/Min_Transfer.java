package webank_2;

import java.util.Scanner;

public class Min_Transfer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String arrString[] = s.split(" ");
		int area = 0;
		
		int[] a = new int[arrString.length];
		for(int i=0;i<6;i++) {
			a[i] = Integer.parseInt(arrString[i]);
		}
		for(int j=0;j<6;j++) {
			area = area+(j+1)*(j+1)*a[j];
		}
		if(area%36 == 0) {
			System.out.println(area/36);
		}else {
			System.out.println(area/36+1);
		}
	}
}
