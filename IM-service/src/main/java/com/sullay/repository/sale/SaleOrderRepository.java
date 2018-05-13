package com.sullay.repository.sale;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sullay.model.sale.SaleOrder;

public interface SaleOrderRepository extends JpaRepository<SaleOrder, Integer>{
	public SaleOrder findById(Integer id);
}
