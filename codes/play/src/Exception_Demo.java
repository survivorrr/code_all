
public class Exception_Demo {
	public static void main(String[] args) {
		int[] arr = {};
		function(arr);
	}
	public static void function(int[] arr) {
		if (arr.length==0) {
			throw new RuntimeException();
		}
	}
}
