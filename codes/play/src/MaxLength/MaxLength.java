package MaxLength;


public class MaxLength {
	public static void main(String[] args) {
		String str = "dfhabcdefGhijklmnfhfdsabc";
//		System.out.println(str.charAt(9));
		String str1 = function(str);
		System.out.println(str1);
	}
	
	public static String function(String str) {
		String sonstr = str.charAt(0)+"";	
		String sonstr1 = "";
		int temp = 1;
		int max = 0;
		for(int i=0;i<str.length()-1;i++) {
			char pre = str.charAt(i);
			char now = str.charAt(i+1);
			if(now-pre == 1 || now-pre == -31 || now-pre == 33) {
				sonstr = sonstr+now;
				temp++;
			}else {
				if(temp > max) {
					max = temp;
					sonstr1 = sonstr;
				}	
				sonstr = now+"";
				temp = 1;
			}
		}
		if(temp > max) {
			max = temp;
			return sonstr;
		}else {
			return sonstr1;
		}
	}
}
