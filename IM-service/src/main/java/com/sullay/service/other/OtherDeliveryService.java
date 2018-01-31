package com.sullay.service.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.other.OtherDelivery;
import com.sullay.repository.other.OtherDeliveryRepository;

@Service
public class OtherDeliveryService {
	@Autowired
	OtherDeliveryRepository otherDeliveryRepository;
	public void create(OtherDelivery otherDelivery){
		otherDeliveryRepository.save(otherDelivery);
	}
	public void detele(OtherDelivery otherDelivery){
		otherDeliveryRepository.delete(otherDelivery);
	}
	public void update(OtherDelivery otherDelivery){
		otherDeliveryRepository.save(otherDelivery);
	}
	public Page<OtherDelivery> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return otherDeliveryRepository.findAll(pageable);
	}
}
