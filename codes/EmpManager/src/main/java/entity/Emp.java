package entity;

import java.io.Serializable;
/*���飺
 * 1.����ʹ�÷�װ���ͣ���Ϊ���Ȼ������Ͷ���null
 * 2.ʹ��java.sql���µ����ڣ���ΪJDBC֧������������
 * 
 * */
public class Emp implements Serializable{
	private Integer empno;
	private String ename;
	private String job;
	private Double sal;
	/**
	 * @return the empno
	 */
	public Integer getEmpno() {
		return empno;
	}
	/**
	 * @param empno the empno to set
	 */
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}
	/**
	 * @param ename the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}
	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * @return the sal
	 */
	public Double getSal() {
		return sal;
	}
	/**
	 * @param sal the sal to set
	 */
	public void setSal(Double sal) {
		this.sal = sal;
	}
	
}
