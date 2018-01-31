package com.sullay.service.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.other.InReceipt;
import com.sullay.repository.other.InReceiptRepository;

@Service
public class InReceiptService {
	@Autowired
	InReceiptRepository inReceiptRepository;
	public void create(InReceipt inReceipt){
		inReceiptRepository.save(inReceipt);
	}
	public void detele(InReceipt inReceipt){
		inReceiptRepository.delete(inReceipt);
	}
	public void update(InReceipt inReceipt){
		inReceiptRepository.save(inReceipt);
	}
	public Page<InReceipt> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return inReceiptRepository.findAll(pageable);
	}
}
