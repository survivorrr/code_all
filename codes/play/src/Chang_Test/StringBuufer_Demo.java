package Chang_Test;

public class StringBuufer_Demo {
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("we are happy");
		String str1 = str.toString();
		StringBuffer newstr = new StringBuffer();
		char[] ch = str1.toCharArray();
		for(char c : ch) {
			if(c!=' ') {
				newstr.append(c);
			}else {
				newstr.append("%20");
			}
		}
		System.out.println(newstr);
	}
}
