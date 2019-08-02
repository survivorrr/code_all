package demo;
/*
 * 这个类就是利用反射来验证ClassPathXmlApplicationContext 是如何读取配置文件的
 * */
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ClassPathXmlApplicationContext {
	//是缓存Spring容器的Bean对象
	private Map<String,Object> beans = new HashMap<String,Object>();
	/*
	 * 利用配置文件初始化当前容器,利用xml配置文件，初始化全部的Bean对象
	 * */
	public ClassPathXmlApplicationContext(String xml) throws Exception {
		//利用DOM4j，读取XML文件，解析XML文件内容，得到Bean的类名和Bean的ID：
		//根据类名动态加载类并且创建对象，将对象和对应的ID添加到map中
		
		//从Resource(classpath)中读取流
		InputStream in = getClass().
				         getClassLoader().getResourceAsStream(xml);
		SAXReader reader = new SAXReader();
		Document doc = reader.read(in);
		in.close();
		//解析xml:<beans><bean><bean>....
		Element root = doc.getRootElement();
		//读取根元素中全部的bean子元素
		List<Element> list = root.elements("bean");
		for(Element e:list){
			//e就是bean元素 id属性和class属性
			String id = e.attributeValue("id");
			String className = e.attributeValue("class");
			
			//动态加载类，动态创建对象。。。。。。动态加载类，动态创建对象。。。。。。动态加载类，动态创建对象。。。。。。动态加载类，动态创建对象
			Class cls = Class.forName(className);
			Object bean = cls.newInstance();
			beans.put(id, bean);
		}
	}
	
	public Object getBean(String id) {
		//（1）根据id在map查找对象，并返回对象
		return beans.get(id);
	}
	//泛型方法：优点是可以减少一次类型转换
	public <T> T getBean(String id, Class<T> cls) {
		//(2)与（1）没有区别，一个在外面转，一个在里面转
		return (T)beans.get(id);
	}
	
}
