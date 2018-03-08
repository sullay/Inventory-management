package com.sullay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//单据设置
@Entity
public class Documents {
	@Id
	@GeneratedValue
	private Integer id;
	//单据名称
	private String name;
	//单据字头
	@Column(unique=true,nullable=false)
	private String prefix;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
}
