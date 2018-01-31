package com.sullay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.Warehouse;
import com.sullay.repository.WarehouseRepository;

@Service
public class WarehouseService {
	@Autowired
	WarehouseRepository warehouseRepository;
	public void create(Warehouse warehouse){
		warehouseRepository.save(warehouse);
	}
	public void detele(Warehouse warehouse){
		warehouseRepository.delete(warehouse);
	}
	public void update(Warehouse warehouse){
		warehouseRepository.save(warehouse);
	}
	public Page<Warehouse> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return warehouseRepository.findAll(pageable);
	}
}
