package Value;

public class SpelBean {
	private String name;
	private String city;
	private double score;
	private String pageSize;

	public SpelBean() {
		System.out.println("SpelBean()");
	}	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setScore(double score) {
		this.score = score;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}


	@Override
	public String toString() {
		return "SpelBean [name=" + name + ", city=" + city + ", score=" + score + ", pageSize=" + pageSize + "]";
	}
	
	
}
