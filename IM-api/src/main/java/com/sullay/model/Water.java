package com.sullay.model;

import java.util.Date;
//库存流水账
public class Water {
	private Integer id;
	//所在仓库
	private Warehouse warehouse;
	//单号
	private String documentCode;
	//商品
	private Goods goods;
	//单据名称
	private String documentName;
	//日期
	private Date date;
	//入库数量
	private int receiptNum;
	//出库数量
	private int deliveryNum;
	//当时库存
	private int nowNum;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	public String getDocumentCode() {
		return documentCode;
	}
	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getReceiptNum() {
		return receiptNum;
	}
	public void setReceiptNum(int receiptNum) {
		this.receiptNum = receiptNum;
	}
	public int getDeliveryNum() {
		return deliveryNum;
	}
	public void setDeliveryNum(int deliveryNum) {
		this.deliveryNum = deliveryNum;
	}
	public int getNowNum() {
		return nowNum;
	}
	public void setNowNum(int nowNum) {
		this.nowNum = nowNum;
	}
	
}
