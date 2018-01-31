package com.sullay.service.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.other.Transfer;
import com.sullay.repository.other.TransferRepository;

@Service
public class TransferService {
	@Autowired
	TransferRepository transferRepository;
	public void create(Transfer transfer){
		transferRepository.save(transfer);
	}
	public void detele(Transfer transfer){
		transferRepository.delete(transfer);
	}
	public void update(Transfer transfer){
		transferRepository.save(transfer);
	}
	public Page<Transfer> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return transferRepository.findAll(pageable);
	}
}
