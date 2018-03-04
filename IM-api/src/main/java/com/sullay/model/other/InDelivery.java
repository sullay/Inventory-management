package com.sullay.model.other;

import java.util.Date;
import java.util.Set;

import com.sullay.model.Water;

//内部领用单
public class InDelivery {
	private Integer id;
	//领用单号
	private String code;
	//领用部门
	private String department;
	//领用人
	private String people;
	//日期
	private Date date;
	//备注
	private String extend;
	//流水账单
	private Set<Water> waters;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}
	public Set<Water> getWaters() {
		return waters;
	}
	public void setWaters(Set<Water> waters) {
		this.waters = waters;
	}
	
	
}
