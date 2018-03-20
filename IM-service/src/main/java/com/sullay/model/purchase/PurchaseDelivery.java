package com.sullay.model.purchase;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.sullay.model.Water;
import com.sullay.model.finance.Receivable;

//采购退货单
@Entity
public class PurchaseDelivery {
	@Id
	@GeneratedValue
	private Integer id;
	//退货单号
	@Column(unique=true,nullable=false)
	private String code;
	//采购信息
	@ManyToOne
	@JoinColumn(name="Pid")
	private PurchaseInfo purchaseInfo;
	//备注
	private String extend;
	//单据日期
	private Date date;
	//库存流水账
	@OneToMany(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="PurchaseReceipt_id")
	private Set<Water> waters;
	//应收款记录
	@OneToOne(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="rid")
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
	public Receivable getReceivable() {
		return receivable;
	}
	public void setReceivable(Receivable receivable) {
		this.receivable = receivable;
	}
	
}
