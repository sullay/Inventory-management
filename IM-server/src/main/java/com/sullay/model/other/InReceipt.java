package com.sullay.model.other;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.sullay.model.Water;

//内部反退单
@Entity
public class InReceipt {
	@Id
	@GeneratedValue
	private Integer id;
	//反退单号
	@Column(unique=true,nullable=false)
	private String code;
	//日期
	private Date date;
	//备注
	private String extend;
	//流水账单
	@OneToMany(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="InReceipt_id")
	private Water water;
	//领用单号
	@ManyToOne
	@JoinColumn(name="D_id")
	private InDelivery indelivery;
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
	public Water getWater() {
		return water;
	}
	public void setWater(Water water) {
		this.water = water;
	}
	public InDelivery getIndelivery() {
		return indelivery;
	}
	public void setIndelivery(InDelivery indelivery) {
		this.indelivery = indelivery;
	}
	
}
