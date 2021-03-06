package com.sullay.model.sale;

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
import com.sullay.model.finance.Payable;

//销售退货单
@Entity
public class SaleReceipt {
	@Id
	@GeneratedValue
	private Integer id;
	//退货入库单号
	@Column(unique=true,nullable=false)
	private String code;
	//销售订单
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},fetch=FetchType.EAGER)
	@JoinColumn(name="Sid")
	private SaleOrder saleOrder;
	//备注
	private String extend;
	//单据日期
	private Date date;
	//库存流水账
	@OneToMany(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="SaleReceipt_id")
	private Set<Water> waters;

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
	
	
	public SaleOrder getSaleOrder() {
		return saleOrder;
	}
	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
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
	public Payable getPayable() {
		return payable;
	}
	public void setPayable(Payable payable) {
		this.payable = payable;
	}
	
	
}
