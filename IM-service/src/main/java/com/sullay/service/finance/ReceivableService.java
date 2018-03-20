package com.sullay.service.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sullay.model.finance.Receivable;
import com.sullay.repository.finance.ReceivableRepository;


@Service
public class ReceivableService {
	@Autowired
	ReceivableRepository receivableRepository;
	public void create(Receivable receivable){
		receivableRepository.save(receivable);
	}
	public void detele(Receivable receivable){
		receivableRepository.delete(receivable);
	}
	public void update(Receivable receivable){
		receivableRepository.save(receivable);                                                                                                         
	}
	public Page<Receivable> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size, new Sort(Direction.DESC, "date"));
		return receivableRepository.findAll(pageable);
	}
}
