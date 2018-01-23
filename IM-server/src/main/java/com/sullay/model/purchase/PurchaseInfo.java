package com.sullay.model.purchase;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sullay.model.Goods;

//采购信息
@Entity
public class PurchaseInfo {
	@Id
	@GeneratedValue
	private Integer id;
	//采购商品
	@ManyToOne
	@JoinColumn(name="Gid")
	private Goods goods;
	//订单数量
	private int number;
	//到货数量
	private int Arrivals;
	//采购价格
	private double price;
	//到货日期
	private Date date;
	//备注
	private String extend;
	//采购订单
	@ManyToOne(cascade= {CascadeType.ALL})
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
		return Arrivals;
	}
	public void setArrivals(int arrivals) {
		Arrivals = arrivals;
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
