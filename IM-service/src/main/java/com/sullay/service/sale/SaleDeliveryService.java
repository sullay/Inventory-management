package com.sullay.service.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.sale.SaleDelivery;
import com.sullay.repository.sale.SaleDeliveryRepository;
@Service
public class SaleDeliveryService {
	@Autowired
	SaleDeliveryRepository saleDeliveryRepository;
	public void create(SaleDelivery saleDelivery){
		saleDeliveryRepository.save(saleDelivery);
	}
	public void detele(SaleDelivery saleDelivery){
		saleDeliveryRepository.delete(saleDelivery);
	}
	public void update(SaleDelivery saleDelivery){
		saleDeliveryRepository.save(saleDelivery);
	}
	public Page<SaleDelivery> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return saleDeliveryRepository.findAll(pageable);
	}
}
