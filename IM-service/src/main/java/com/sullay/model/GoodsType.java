package com.sullay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//商品种类
@Entity
public class GoodsType {
	@Id
	@GeneratedValue
	private Integer id;
	//商品种类代号
	@Column(unique=true,nullable=false)
	private String code;
	//商品种类名称
	private String name;
	//编码前缀
	@Column(unique=true,nullable=false)
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
