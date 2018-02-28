package com.sullay.model.finance;

import com.sullay.model.purchase.PurchaseDelivery;
import com.sullay.model.sale.SaleOrder;

//应收款记录
public class Receivables {
	public static enum State {
		INVALID,
		INCOMPLETE,
		COMPLETE
    }
	private Integer id;
	//应收款单号
	private String code;
	//销售订单
	private SaleOrder saleOrder;
	//采购退货单
	private PurchaseDelivery purchaseDelivery;
	//已收金额
	private Double amountReceived=0.0;
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
	public SaleOrder getSaleOrder() {
		return saleOrder;
	}
	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}
	public Double getAmountReceived() {
		return amountReceived;
	}
	public void setAmountReceived(Double amountReceived) {
		this.amountReceived = amountReceived;
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
	public PurchaseDelivery getPurchaseDelivery() {
		return purchaseDelivery;
	}
	public void setPurchaseDelivery(PurchaseDelivery purchaseDelivery) {
		this.purchaseDelivery = purchaseDelivery;
	}
	
}
