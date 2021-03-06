package com.sullay.model.finance;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//应收款记录
@Entity
public class Receivable {
	public static enum State {
		INVALID,
		INCOMPLETE,
		COMPLETE
    }
	@Id
	@GeneratedValue
	private Integer id;
	//应收款单号
	@Column(unique=true,nullable=false)
	private String code;
	//已收金额
	private Double amountReceived=0.0;
	//总金额
	private Double amount;
	//状态
	@Enumerated(EnumType.ORDINAL)
	private State state=State.INCOMPLETE;
	//备注
	private String extend;
	//日期
	private Date date;
	private String dealer;
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
	public String getDealer() {
		return dealer;
	}
	public void setDealer(String dealer) {
		this.dealer = dealer;
	}
	
}
