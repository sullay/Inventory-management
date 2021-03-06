package com.sullay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
		Pageable pageable = new PageRequest(page, size, new Sort(Direction.DESC, "goods"));
		return stockRepository.findAll(pageable);
	}
	public List<Stock> findByGoodsId(int gid){
		return stockRepository.findByGoodsId(gid);
	}
	public Stock findByGoodsIdAndWarehouseId(int gid, int wid) {
		return stockRepository.findByGoodsIdAndWarehouseId(gid, wid);
	}
	public Page<Stock> findWarning(int page,int size){
		Pageable pageable = new PageRequest(page, size, new Sort(Direction.DESC, "goods"));
		return stockRepository.findWarning(pageable);
	}
	public Stock findOne(int id) {
		return stockRepository.findOne(id);
	}
}
