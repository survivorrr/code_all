import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_Demo {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy:  HH:mm:ss");
		String now = sdf.format(date);
		System.out.println(now);
	}
}
