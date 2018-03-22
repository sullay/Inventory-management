package com.sullay.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//库存流水账
@Entity
public class Water {
	@Id
	@GeneratedValue
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
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinColumn(name="sid")
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
