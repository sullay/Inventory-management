package com.sullay.model.sale;

import java.util.Date;

import com.sullay.model.Goods;

//销售信息
public class SaleInfo {
	private Integer id;
	//销售商品
	private Goods goods;
	//订单数量
	private int number;
	//出货数量
	private int shipment;
	//销售价格
	private double price;
	//到货日期
	private Date date;
	//备注
	private String extend;
	//销售订单
	private SaleOrder saleOrder;
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
	public int getShipment() {
		return shipment;
	}
	public void setShipment(int shipment) {
		this.shipment = shipment;
	}
	public SaleOrder getSaleOrder() {
		return saleOrder;
	}
	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}
	
}
