package com.sullay.service.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.purchase.PurchaseOrder;
import com.sullay.repository.purchase.PurchaseOrderRepository;
@Service
public class PurchaseOrderService {
	@Autowired
	PurchaseOrderRepository purchaseOrderRepository;
	public void create(PurchaseOrder purchaseOrder){
		purchaseOrderRepository.save(purchaseOrder);
	}
	public void detele(PurchaseOrder purchaseOrder){
		purchaseOrderRepository.delete(purchaseOrder);
	}
	public void update(PurchaseOrder purchaseOrder){
		purchaseOrderRepository.save(purchaseOrder);
	}
	public Page<PurchaseOrder> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return purchaseOrderRepository.findAll(pageable);
	}
	public PurchaseOrder findById(Integer id) {
		return purchaseOrderRepository.findById(id);
	}
}
