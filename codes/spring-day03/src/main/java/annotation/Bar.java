package annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("bar")
public class Bar {
	private Waiter wt;
	public Bar() {
		System.out.println("Bar()");
	}
	@Resource(name="wt")
	public void setWt(Waiter wt) {
		System.out.println("setWt()");
		this.wt = wt;
	}

	@Override
	public String toString() {
		return "Bar [wt=" + wt + "]";
	}
}
