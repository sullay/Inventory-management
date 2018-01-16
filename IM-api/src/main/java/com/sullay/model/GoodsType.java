package com.sullay.model;

//商品种类
public class GoodsType {
	private Integer id;
	//商品种类代号
	private String code;
	//商品种类名称
	private String name;
	//编码前缀
	private String codingPrefix;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCodingPrefix() {
		return codingPrefix;
	}
	public void setCodingPrefix(String codingPrefix) {
		this.codingPrefix = codingPrefix;
	}
	
}
