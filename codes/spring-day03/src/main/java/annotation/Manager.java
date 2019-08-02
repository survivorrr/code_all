package annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mg")
public class Manager {
	@Value("#{config.pagesize}")
	private String pageSize;
	@Value("»¨Ç§¹Ç")
	private String name;
	
	@Override
	public String toString() {
		return "Manager [pageSize=" + pageSize + ", name=" + name + "]";
	}

	public Manager() {
		System.out.println("Manager()");
		
	}
}
