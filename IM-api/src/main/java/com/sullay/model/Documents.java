package com.sullay.model;

//单据设置
public class Documents {
	private Integer id;
	//单据名称
	private String name;
	//单据字头
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
