package com.sullay.service.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sullay.model.finance.Detail;
import com.sullay.repository.finance.DetailRepository;


@Service
public class DetailService {
	@Autowired
	DetailRepository detailRepository;
	public void create(Detail detail){
		detailRepository.save(detail);
	}
	public void detele(Detail detail){
		detailRepository.delete(detail);
	}
	public void update(Detail detail){
		detailRepository.save(detail);
	}
	public Page<Detail> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size, new Sort(Direction.DESC, "date"));
		return detailRepository.findAll(pageable);
	}
}
