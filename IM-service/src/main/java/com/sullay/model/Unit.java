package com.sullay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//单位类
@Entity
public class Unit {
	@Id
	@GeneratedValue
	private Integer id;
	//库存单位代号
	@Column(unique=true,nullable=false)
	private String code;
	//库存单位说明
	private String description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
