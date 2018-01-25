package com.sullay.service.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.sale.SaleReceipt;
import com.sullay.repository.sale.SaleReceiptRepository;
@Service
public class SaleReceiptService {
	@Autowired
	SaleReceiptRepository saleReceiptRepository;
	public void create(SaleReceipt saleReceipt){
		saleReceiptRepository.save(saleReceipt);
	}
	public void detele(SaleReceipt saleReceipt){
		saleReceiptRepository.delete(saleReceipt);
	}
	public void update(SaleReceipt saleReceipt){
		saleReceiptRepository.save(saleReceipt);
	}
	public Page<SaleReceipt> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return saleReceiptRepository.findAll(pageable);
	}
}
