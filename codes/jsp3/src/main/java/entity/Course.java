package entity;

import java.io.Serializable;

public class Course implements Serializable {
	//���������
	private Integer courseId;
	private String name;
	private Integer days;
	/**
	 * @return the courseId
	 */
	//1.��get/set��Ӧ�����Խ�Bean����
	//2.ͨ��get/set��Ӧ������������Ϊ������
	//3.ȥ��get��������ĸСд�ĵ�����Bean����
	//Bean����ͨ�����Ͷ�������һ�£�Ҳ�����޸�Ϊ��һ��
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
