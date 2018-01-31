package com.sullay.service.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.other.OtherReceipt;
import com.sullay.repository.other.OtherReceiptRepository;

@Service
public class OtherReceiptService {
	@Autowired
	OtherReceiptRepository otherReceiptRepository;
	public void create(OtherReceipt otherReceipt){
		otherReceiptRepository.save(otherReceipt);
	}
	public void detele(OtherReceipt otherReceipt){
		otherReceiptRepository.delete(otherReceipt);
	}
	public void update(OtherReceipt otherReceipt){
		otherReceiptRepository.save(otherReceipt);
	}
	public Page<OtherReceipt> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return otherReceiptRepository.findAll(pageable);
	}
}
