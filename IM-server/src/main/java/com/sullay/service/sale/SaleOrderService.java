package com.sullay.service.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.sale.SaleOrder;
import com.sullay.repository.sale.SaleOrderRepository;
@Service
public class SaleOrderService {
	@Autowired
	SaleOrderRepository saleOrderRepository;
	public void create(SaleOrder saleOrder){
		saleOrderRepository.save(saleOrder);
	}
	public void detele(SaleOrder saleOrder){
		saleOrderRepository.delete(saleOrder);
	}
	public void update(SaleOrder saleOrder){
		saleOrderRepository.save(saleOrder);
	}
	public Page<SaleOrder> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return saleOrderRepository.findAll(pageable);
	}
}
