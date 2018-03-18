package com.sullay.service.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sullay.model.finance.Receivables;
import com.sullay.repository.finance.ReceivablesRepository;


@Service
public class ReceivablesService {
	@Autowired
	ReceivablesRepository receivablesRepository;
	public void create(Receivables receivables){
		receivablesRepository.save(receivables);
	}
	public void detele(Receivables receivables){
		receivablesRepository.delete(receivables);
	}
	public void update(Receivables receivables){
		receivablesRepository.save(receivables);                                                                                                         
	}
	public Page<Receivables> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size, new Sort(Direction.DESC, "date"));
		return receivablesRepository.findAll(pageable);
	}
}
