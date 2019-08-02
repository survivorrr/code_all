package Iterator_Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Iterator_Demo {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("aaa","xxx");
		map.put("aaa","yyy");
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()) {
			 Map.Entry<String,String> entry = (Map.Entry<String,String>) it.next();
			 String key = entry.getKey();
			 String value = entry.getValue();
			 System.out.println(key+"  "+value);
		}
	}
}
