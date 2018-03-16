package com.sullay.model.purchase;

import java.util.Date;
import java.util.Set;

import com.sullay.model.Water;
import com.sullay.model.finance.Receivables;

//采购退货单
public class PurchaseDelivery {
	private Integer id;
	//退货单号
	private String code;
	//采购信息
	private PurchaseInfo purchaseInfo;
	//备注
	private String extend;
	//单据日期
	private Date date;
	//库存流水账
	private Set<Water> waters;
	//应收款记录
	private Receivables receivables;
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
	
	public PurchaseInfo getPurchaseInfo() {
		return purchaseInfo;
	}
	public void setPurchaseInfo(PurchaseInfo purchaseInfo) {
		this.purchaseInfo = purchaseInfo;
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
	public Set<Water> getWaters() {
		return waters;
	}
	public void setWaters(Set<Water> waters) {
		this.waters = waters;
	}
	public Receivables getReceivables() {
		return receivables;
	}
	public void setReceivables(Receivables receivables) {
		this.receivables = receivables;
	}
	
}
