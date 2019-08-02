import java.util.Arrays;
import java.util.Scanner;


public class ScannerDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = null;
		s = sc.next();
		char[] ch = new char[100];
		ch = s.toCharArray();
	/*	for(int i=0;i<ch.length;i++){
			System.out.print(ch[i]+" ");
		}
		*/
	    Arrays.sort(ch);
	    char num  = ch[0];
	//    System.out.println(num);
	    for(int j=0;j<ch.length-1;j++){
	    	if(ch[j+1] != ch[j]){
	    		System.out.print(ch[j]);
	    	}
	    }
	//    System.out.println(num);

//		System.out.println(s.toCharArray());
	}

}
