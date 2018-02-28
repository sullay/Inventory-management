package com.sullay.model.finance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.sullay.model.purchase.PurchaseDelivery;
import com.sullay.model.sale.SaleOrder;

//应收款记录
@Entity
public class Receivables {
	public static enum State {
		INVALID,
		INCOMPLETE,
		COMPLETE
    }
	@Id
	@GeneratedValue
	private Integer id;
	//应收款单号
	@Column(unique=true,nullable=false)
	private String code;
	//销售订单
	@OneToOne
	@JoinColumn(name="sid")
	private SaleOrder saleOrder;
	//采购退货单
	@OneToOne
	@JoinColumn(name="pid")
	private PurchaseDelivery purchaseDelivery;
	//已收金额
	private Double amountReceived=0.0;
	//状态
	@Enumerated(EnumType.ORDINAL)
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
