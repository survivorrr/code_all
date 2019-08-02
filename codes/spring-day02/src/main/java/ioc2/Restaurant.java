package ioc2;

public class Restaurant {
	private Waiter wt;
	public Restaurant() {
		System.out.println("Restaurant()");
	}
	public void setWt(Waiter wt) {
		System.out.println("setWt()");
		this.wt=wt;
	}
	public String toString() {
		return "Restaurant [wt="+wt+"]";
	}
}
