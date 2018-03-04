package com.sullay.model.other;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.sullay.model.Water;

//转仓单
@Entity
public class Transfer {
	@Id
	@GeneratedValue
	private Integer id;
	//转仓单号
	@Column(unique=true,nullable=false)
	private String code;
	//转出流水
	@OneToMany(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="TransferDelivery_id")
	private Set<Water> delivery;
	//转入流水
	@OneToMany(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="TransferReceipt_id")
	private Set<Water> receipt;
	//单据日期
	private Date date;
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
	
	public Set<Water> getDelivery() {
		return delivery;
	}
	public void setDelivery(Set<Water> delivery) {
		this.delivery = delivery;
	}
	public Set<Water> getReceipt() {
		return receipt;
	}
	public void setReceipt(Set<Water> receipt) {
		this.receipt = receipt;
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
	
}
