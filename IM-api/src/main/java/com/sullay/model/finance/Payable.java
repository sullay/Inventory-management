package com.sullay.model.finance;

import com.sullay.model.purchase.PurchaseOrder;
import com.sullay.model.sale.SaleReceipt;

//应付款记录
public class Payable {
	public static enum State {
		INVALID,
		INCOMPLETE,
		COMPLETE
    }
	private Integer id;
	//应付款单号
	private String code;
	//采购订单
	private PurchaseOrder purchaseOrder;
	//销售退货单
	private SaleReceipt saleReceipt;
	//已付金额
	private Double amountPaid=0.0;
	//状态
	private State state=State.INCOMPLETE;
	//备注
	private String extend;
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
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public Double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}
	public SaleReceipt getSaleReceipt() {
		return saleReceipt;
	}
	public void setSaleReceipt(SaleReceipt saleReceipt) {
		this.saleReceipt = saleReceipt;
	}
	
	
}
