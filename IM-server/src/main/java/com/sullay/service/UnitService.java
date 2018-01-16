package com.sullay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.Unit;
import com.sullay.repository.UnitRepository;

@Service
public class UnitService {
	@Autowired
	UnitRepository unitRepository;
	public void create(Unit unit){
		unitRepository.save(unit);
	}
	public void detele(Unit unit){
		unitRepository.delete(unit);
	}
	public void update(Unit unit){
		unitRepository.save(unit);
	}
	public Page<Unit> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return unitRepository.findAll(pageable);
	}
}
