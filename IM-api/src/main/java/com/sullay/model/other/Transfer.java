package com.sullay.model.other;

import java.sql.Date;

import com.sullay.model.Water;

//转仓单
public class Transfer {
	private Integer id;
	//转仓单号
	private String code;
	//转出流水
	private Water delivery;
	//转入流水
	private Water receipt;
	//单据日期
	private Date date;
	//备注
	private String extend;
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
	public Water getDelivery() {
		return delivery;
	}
	public void setDelivery(Water delivery) {
		this.delivery = delivery;
	}
	public Water getReceipt() {
		return receipt;
	}
	public void setReceipt(Water receipt) {
		this.receipt = receipt;
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
	
}
