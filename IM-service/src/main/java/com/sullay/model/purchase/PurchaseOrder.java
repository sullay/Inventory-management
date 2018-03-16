package com.sullay.model.purchase;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.sullay.model.finance.Payable;

//采购订单
@Entity
public class PurchaseOrder {
	
	public static enum State {
		INVALID,
		INCOMPLETE,
		COMPLETE
    }
	
	@Id
	@GeneratedValue
	private Integer id;
	//订单编号
	@Column(unique=true,nullable=false)
	private String code;
	//供应商名称
	private String supplier;
	//采购员名称
	private String buyer;
	//备注
	private String extend;
	//单据日期
	private Date date;
	//订单状态
	@Enumerated(EnumType.ORDINAL)
	private State state=State.INCOMPLETE;
	//采购信息
	@OneToMany(mappedBy="purchaseOrder",cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	private Set<PurchaseInfo> purchaseInfos;
	//应付款记录
	@OneToOne(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="pid")
	private Payable payable;
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
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
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
	public Set<PurchaseInfo> getPurchaseInfos() {
		return purchaseInfos;
	}
	public void setPurchaseInfos(Set<PurchaseInfo> purchaseInfos) {
		this.purchaseInfos = purchaseInfos;
	}
	public Payable getPayable() {
		return payable;
	}
	public void setPayable(Payable payable) {
		this.payable = payable;
	}
	
}
