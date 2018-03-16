package com.sullay.model.finance;

import java.util.Date;

//付款记录
public class Pay {
	private Integer id;
	private Payable payable;
	//日期
	private Date date;
	//付款金额
	private Double amount;
	//备注
	private String extend;
	private Detail detail;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Payable getPayable() {
		return payable;
	}
	public void setPayable(Payable payable) {
		this.payable = payable;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}
	public Detail getDetail() {
		return detail;
	}
	public void setDetail(Detail detail) {
		this.detail = detail;
	}
	
}
