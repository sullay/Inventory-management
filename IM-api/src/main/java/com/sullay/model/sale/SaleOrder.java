package com.sullay.model.sale;

import java.util.Date;
import java.util.Set;

import com.sullay.model.finance.Receivable;

//销售订单
public class SaleOrder {
	
	public static enum State {
		INVALID,
		INCOMPLETE,
		COMPLETE
    }
	private Integer id;
	//订单编号
	private String code;
	//客户名称
	private String customer;
	//备注
	private String extend;
	//单据日期
	private Date date;
	//订单状态
	private State state=State.INCOMPLETE;
	//销售信息
	private Set<SaleInfo> saleInfos;
	//应收款记录
	private Receivable receivable;
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
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Set<SaleInfo> getSaleInfos() {
		return saleInfos;
	}
	public void setSaleInfos(Set<SaleInfo> saleInfos) {
		this.saleInfos = saleInfos;
	}
	public Receivable getReceivable() {
		return receivable;
	}
	public void setReceivable(Receivable receivable) {
		this.receivable = receivable;
	}

	
	
}
