package TreadDemo02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * �����ϻ���mapת���̰߳�ȫ��
 * @author Administrator
 *
 */
public class Thread_zhuang_syn {
	public static void main(String[] args) {
		/**
		 * ArrayList��linkedList�����̲߳���ȫ��
		 */
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		//����������ת��Ϊ�̰߳�ȫ�ļ���
		list = Collections.synchronizedList(list);
		System.out.println(list);
		
		/**
		 * HashSet�����̰߳�ȫ��
		 */
		Set<String> set = new HashSet<String>(list);
		System.out.println(set);
		//��������set����ת��Ϊ�̰߳�ȫ��
		set = Collections.synchronizedSet(set);
		System.out.println(set);
		/**
		 * HashMapҲ�����̰߳�ȫ��
		 */
		
		/**
		 * API�ֲ�����˵���������̰߳�ȫ�ļ�����ô���ж���Ԫ�صĲ������磺add��remove�ȷ�����������������������⣬��Ҫ����ά�������ϵ
		 */
	}
}
