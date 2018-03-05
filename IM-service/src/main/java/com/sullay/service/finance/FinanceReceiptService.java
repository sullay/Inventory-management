package com.sullay.service.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.finance.FinanceReceipt;
import com.sullay.repository.finance.FinanceReceiptRepository;


@Service
public class FinanceReceiptService {
	@Autowired
	FinanceReceiptRepository financeReceiptRepository;
	public void create(FinanceReceipt financeReceipt){
		financeReceiptRepository.save(financeReceipt);
	}
	public void detele(FinanceReceipt financeReceipt){
		financeReceiptRepository.delete(financeReceipt);
	}
	public void update(FinanceReceipt financeReceipt){
		financeReceiptRepository.save(financeReceipt);
	}
	public Page<FinanceReceipt> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return financeReceiptRepository.findAll(pageable);
	}
}
