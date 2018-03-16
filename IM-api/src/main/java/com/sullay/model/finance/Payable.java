package com.sullay.model.finance;

//应付款记录
public class Payable {
	public static enum State {
		INVALID,
		INCOMPLETE,
		COMPLETE
    }
	private Integer id;
	//应付款单号
	private String code;
	//已付金额
	private Double amountPaid=0.0;
	//总金额
	private Double amount;
	//状态
	private State state=State.INCOMPLETE;
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
	public Double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
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
	
	
	
}
