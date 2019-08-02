package annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sb1")
@Scope("singleton")
@Lazy(true)
public class SomeBean {
	@PostConstruct
	public void init() {
		System.out.println("init()");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("destroy()");
	}
	public SomeBean() {
		System.out.println("SomeBean()");
	}
}
