package com.sullay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sullay.model.Water;
import com.sullay.repository.WaterRepository;

@Service
public class WaterService {
	@Autowired
	WaterRepository waterRepository;
	public void create(Water water){
		waterRepository.save(water);
	}
	public void detele(Water water){
		waterRepository.delete(water);
	}
	public void update(Water water){
		waterRepository.save(water);
	}
	public Page<Water> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size, new Sort(Direction.DESC, "date"));
		return waterRepository.findAll(pageable);
	}
}
