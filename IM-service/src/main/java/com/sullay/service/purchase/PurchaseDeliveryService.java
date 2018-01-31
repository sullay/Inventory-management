package com.sullay.service.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.purchase.PurchaseDelivery;
import com.sullay.repository.purchase.PurchaseDeliveryRepository;
@Service
public class PurchaseDeliveryService {
	@Autowired
	PurchaseDeliveryRepository purchaseDeliveryRepository;
	public void create(PurchaseDelivery purchaseDelivery){
		purchaseDeliveryRepository.save(purchaseDelivery);
	}
	public void detele(PurchaseDelivery purchaseDelivery){
		purchaseDeliveryRepository.delete(purchaseDelivery);
	}
	public void update(PurchaseDelivery purchaseDelivery){
		purchaseDeliveryRepository.save(purchaseDelivery);
	}
	public Page<PurchaseDelivery> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return purchaseDeliveryRepository.findAll(pageable);
	}
}
