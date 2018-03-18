package com.sullay.service.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sullay.model.finance.Payable;
import com.sullay.repository.finance.PayableRepository;


@Service
public class PayableService {
	@Autowired
	PayableRepository payableRepository;
	public void create(Payable payable){
		payableRepository.save(payable);
	}
	public void detele(Payable payable){
		payableRepository.delete(payable);
	}
	public void update(Payable payable){
		payableRepository.save(payable);                                                                                                         
	}
	public Page<Payable> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size, new Sort(Direction.DESC, "date"));
		return payableRepository.findAll(pageable);
	}
}
