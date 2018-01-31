package com.sullay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//库存类
@Entity
public class Stock {
	@Id
	@GeneratedValue
	private Integer id;
	//商品
	@ManyToOne
	@JoinColumn(name="Gid")
	private Goods goods;
	//仓库
	@ManyToOne
	@JoinColumn(name="Wid")
	private Warehouse warehouse;
	//数量
	private Integer number;
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
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
}
