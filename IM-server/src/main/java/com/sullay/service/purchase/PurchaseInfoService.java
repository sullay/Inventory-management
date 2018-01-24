package com.sullay.service.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.purchase.PurchaseInfo;
import com.sullay.repository.purchase.PurchaseInfoRepository;
@Service
public class PurchaseInfoService {
	@Autowired
	PurchaseInfoRepository purchaseInfoRepository;
	public void create(PurchaseInfo purchaseInfo){
		purchaseInfoRepository.save(purchaseInfo);
	}
	public void detele(PurchaseInfo purchaseInfo){
		purchaseInfoRepository.delete(purchaseInfo);
	}
	public void update(PurchaseInfo purchaseInfo){
		purchaseInfoRepository.save(purchaseInfo);
	}
	public Page<PurchaseInfo> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return purchaseInfoRepository.findAll(pageable);
	}
}
