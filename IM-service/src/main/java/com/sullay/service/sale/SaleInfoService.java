package com.sullay.service.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.sale.SaleInfo;
import com.sullay.repository.sale.SaleInfoRepository;
@Service
public class SaleInfoService {
	@Autowired
	SaleInfoRepository saleInfoRepository;
	public void create(SaleInfo saleInfo){
		saleInfoRepository.save(saleInfo);
	}
	public void detele(SaleInfo saleInfo){
		saleInfoRepository.delete(saleInfo);
	}
	public void update(SaleInfo saleInfo){
		saleInfoRepository.save(saleInfo);
	}
	public Page<SaleInfo> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return saleInfoRepository.findAll(pageable);
	}
}
