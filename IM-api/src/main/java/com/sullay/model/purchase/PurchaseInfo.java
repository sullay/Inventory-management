package com.sullay.model.purchase;

import java.util.Date;

import com.sullay.model.Goods;

//采购信息
public class PurchaseInfo {
	private Integer id;
	//采购商品
	private Goods goods;
	//订单数量
	private int number;
	//到货数量
	private int arrivals;
	//采购价格
	private double price;
	//到货日期
	private Date date;
	//备注
	private String extend;
	//采购订单
	private PurchaseOrder purchaseOrder;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getArrivals() {
		return arrivals;
	}
	public void setArrivals(int arrivals) {
		this.arrivals = arrivals;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	
}
