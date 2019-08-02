package cn.itcast.demo04;
/*
 * MapǶ��
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
		BaseClass.put("001", "����");
		BaseClass.put("002", "����");
		ImproveClass.put("001", "����");
		ImproveClass.put("002", "����");
		
		HashMap<String,HashMap<String,String>> czbk = 
				new HashMap<String,HashMap<String,String>>();
		czbk.put("������", BaseClass);
		czbk.put("��߰�", ImproveClass);
		keySet(czbk);
		System.out.println("====================");
		entrySet(czbk);
	}
	//EntrySet���MapMap����
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
		//��һ�ΰ�Map�еļ����������һ��Set���ϣ��õ��������
		Set<String> classNameSet = czbk.keySet();
		Iterator<String> classNameIt = classNameSet.iterator();
		while(classNameIt.hasNext()){
			String classNameKey = classNameIt.next();
			
			//��ȡczbk�����ֵ
			HashMap<String,String> classMap = czbk.get(classNameKey);
			//��classMap�еļ�����һ��Set����
			Set<String> numSet = classMap.keySet();
			Iterator<String> numSetIt = numSet.iterator();
			while(numSetIt.hasNext()){
				//�ڶ��ΰ�classMap�еļ����
				String numKey =  numSetIt.next();
				//��classMap�е�ֵ���
				String nameValue = classMap.get(numKey);
				System.out.println(classNameKey+".."+numKey+".."+nameValue);
			}
		}
	}
}
