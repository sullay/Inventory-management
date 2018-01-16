package com.sullay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.Goods;
import com.sullay.repository.GoodsRepository;

@Service
public class GoodsService {
	@Autowired
	GoodsRepository goodsRepository;
	public void create(Goods goods){
		goodsRepository.save(goods);
	}
	public void detele(Goods goods){
		goodsRepository.delete(goods);
	}
	public void update(Goods goods){
		goodsRepository.save(goods);
	}
	public Page<Goods> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return goodsRepository.findAll(pageable);
	}
}
