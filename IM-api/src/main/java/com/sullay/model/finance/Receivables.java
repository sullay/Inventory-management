package com.sullay.model.finance;

import java.util.Date;

//应收款记录
public class Receivables {
	public static enum State {
		INVALID,
		INCOMPLETE,
		COMPLETE
    }
	private Integer id;
	//应收款单号
	private String code;
	//已收金额
	private Double amountReceived=0.0;
	//总金额
	private Double amount;
	//状态
	private State state=State.INCOMPLETE;
	//备注
	private String extend;
	//日期
	private Date date;
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
	public Double getAmountReceived() {
		return amountReceived;
	}
	public void setAmountReceived(Double amountReceived) {
		this.amountReceived = amountReceived;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
