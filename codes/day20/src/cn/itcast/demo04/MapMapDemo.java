package cn.itcast.demo04;
/*
 * Map嵌套
 * */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapMapDemo {
	public static void main(String[] args) {
		HashMap<String,String> BaseClass = new HashMap<String,String>();
		HashMap<String,String> ImproveClass = new HashMap<String,String>();
		BaseClass.put("001", "张三");
		BaseClass.put("002", "李四");
		ImproveClass.put("001", "王五");
		ImproveClass.put("002", "赵六");
		
		HashMap<String,HashMap<String,String>> czbk = 
				new HashMap<String,HashMap<String,String>>();
		czbk.put("基础班", BaseClass);
		czbk.put("提高班", ImproveClass);
		keySet(czbk);
		System.out.println("====================");
		entrySet(czbk);
	}
	//EntrySet完成MapMap遍历
	public static void entrySet(HashMap<String,HashMap<String,String>> czbk){
		Set<Map.Entry<String, HashMap<String,String>>> classNameSet = czbk.entrySet();
		Iterator<Entry<String, HashMap<String,String>>> classNameIt = classNameSet.iterator();
		while(classNameIt.hasNext()){
			Entry<String, HashMap<String, String>> classNameEntry = classNameIt.next();
			String className = classNameEntry.getKey();
			HashMap<String,String> student = classNameEntry.getValue();
			Set<Map.Entry<String, String>> studentSet = student.entrySet();
			Iterator<Map.Entry<String,String>> studentIt = studentSet.iterator();
			while(studentIt.hasNext()){
				Entry<String,String> studentEntry = studentIt.next();
				String numKey = studentEntry.getKey();
				String nameValue = studentEntry.getValue();
				System.out.println(className+".."+numKey+".."+nameValue);
			}
		}		
		
	}
	
	public static void keySet(HashMap<String,HashMap<String,String>> czbk){
		//第一次把Map中的键输出，创造一个Set集合，用迭代器输出
		Set<String> classNameSet = czbk.keySet();
		Iterator<String> classNameIt = classNameSet.iterator();
		while(classNameIt.hasNext()){
			String classNameKey = classNameIt.next();
			
			//获取czbk里面的值
			HashMap<String,String> classMap = czbk.get(classNameKey);
			//把classMap中的键创建一个Set集合
			Set<String> numSet = classMap.keySet();
			Iterator<String> numSetIt = numSet.iterator();
			while(numSetIt.hasNext()){
				//第二次把classMap中的键输出
				String numKey =  numSetIt.next();
				//把classMap中的值输出
				String nameValue = classMap.get(numKey);
				System.out.println(classNameKey+".."+numKey+".."+nameValue);
			}
		}
	}
}
