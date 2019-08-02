package entity;

import java.io.Serializable;

public class Course implements Serializable {
	//对象的属性
	private Integer courseId;
	private String name;
	private Integer days;
	/**
	 * @return the courseId
	 */
	//1.和get/set对应的属性叫Bean属性
	//2.通过get/set反应出来的我们以为的属性
	//3.去掉get并将首字母小写的单词是Bean属性
	//Bean属性通常都和对象属性一致，也可以修改为不一致
	public Integer getId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setId(Integer courseId) {
		this.courseId = courseId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the days
	 */
	public Integer getDays() {
		return days;
	}
	/**
	 * @param days the days to set
	 */
	public void setDays(Integer days) {
		this.days = days;
	}
	
}
