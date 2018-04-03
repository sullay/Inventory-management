package com.sullay.model;

import java.util.Date;
//库存流水账
public class Water {
	private Integer id;
	//单号
	private String documentCode;
	//单据名称
	private String documentName;
	//日期
	private Date date;
	//入库数量
	private int receiptNum;
	//出库数量
	private int deliveryNum;
	
	private Stock stock;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDocumentCode() {
		return documentCode;
	}
	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
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
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
}
