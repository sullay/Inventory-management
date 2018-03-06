package com.sullay.model.finance;

import java.util.Date;

//收款记录
public class FinanceReceipt {
	private Integer id;
	private Receivables receivables;
	//日期
	private Date date;
	//收款金额
	private Double amount;
	//备注
	private String extend;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Receivables getReceivables() {
		return receivables;
	}
	public void setReceivables(Receivables receivables) {
		this.receivables = receivables;
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
	
}
