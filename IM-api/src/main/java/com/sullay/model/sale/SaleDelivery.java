package com.sullay.model.sale;

import java.util.Date;
import java.util.Set;

import com.sullay.model.Water;

//销售出库单
public class SaleDelivery {
	private Integer id;
	//销售出库单号
	private String code;
	//销售订单
	private SaleOrder saleOrder;
	//备注
	private String extend;
	//单据日期
	private Date date;
	//库存流水账
	private Set<Water> waters;
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

	
}
