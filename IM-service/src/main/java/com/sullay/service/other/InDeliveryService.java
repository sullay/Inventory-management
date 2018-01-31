package com.sullay.service.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.other.InDelivery;
import com.sullay.repository.other.InDeliveryRepository;

@Service
public class InDeliveryService {
	@Autowired
	InDeliveryRepository inDeliveryRepository;
	public void create(InDelivery inDelivery){
		inDeliveryRepository.save(inDelivery);
	}
	public void detele(InDelivery inDelivery){
		inDeliveryRepository.delete(inDelivery);
	}
	public void update(InDelivery inDelivery){
		inDeliveryRepository.save(inDelivery);
	}
	public Page<InDelivery> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return inDeliveryRepository.findAll(pageable);
	}
}
