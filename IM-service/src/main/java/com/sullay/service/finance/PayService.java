package com.sullay.service.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sullay.model.finance.Pay;
import com.sullay.repository.finance.PayRepository;


@Service
public class PayService {
	@Autowired
	PayRepository payRepository;
	public void create(Pay pay){
		payRepository.save(pay);
	}
	public void detele(Pay pay){
		payRepository.delete(pay);
	}
	public void update(Pay pay){
		payRepository.save(pay);                                                                                                         
	}
	public Page<Pay> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size, new Sort(Direction.DESC, "date"));
		return payRepository.findAll(pageable);
	}
}
