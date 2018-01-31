package com.sullay.service.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.purchase.PurchaseReceipt;
import com.sullay.repository.purchase.PurchaseReceiptRepository;
@Service
public class PurchaseReceiptService {
	@Autowired
	PurchaseReceiptRepository purchaseReceiptRepository;
	public void create(PurchaseReceipt purchaseReceipt){
		purchaseReceiptRepository.save(purchaseReceipt);
	}
	public void detele(PurchaseReceipt purchaseReceipt){
		purchaseReceiptRepository.delete(purchaseReceipt);
	}
	public void update(PurchaseReceipt purchaseReceipt){
		purchaseReceiptRepository.save(purchaseReceipt);
	}
	public Page<PurchaseReceipt> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return purchaseReceiptRepository.findAll(pageable);
	}
}
