package com.sullay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.Stock;
import com.sullay.repository.StockRepository;

@Service
public class StockService {
	@Autowired
	StockRepository stockRepository;
	public void create(Stock stock){
		stockRepository.save(stock);
	}
	public void detele(Stock stock){
		stockRepository.delete(stock);
	}
	public void update(Stock stock){
		stockRepository.save(stock);
	}
	public Page<Stock> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return stockRepository.findAll(pageable);
	}
}
