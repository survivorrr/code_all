package Chang_Test;

public class zifu_and_zifuchuang {
	public static void main(String[] args) {
		String str = "we are happy";
		char[] arr = str.toCharArray();
		for(char a : arr) {
			System.out.print(a+" ");
		}
		System.out.println();
		
		String s = String.valueOf(arr);
		System.out.println(s);
	}
}
