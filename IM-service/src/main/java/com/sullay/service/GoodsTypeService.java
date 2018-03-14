package com.sullay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.GoodsType;
import com.sullay.repository.GoodsTypeRepository;

@Service
public class GoodsTypeService {
	@Autowired
	GoodsTypeRepository goodsTypeRepository;
	public void create(GoodsType goodsType){
		goodsTypeRepository.save(goodsType);
	}
	public void detele(GoodsType goodsType){
		goodsTypeRepository.delete(goodsType);
	}
	public void update(GoodsType goodsType){
		goodsTypeRepository.save(goodsType);
	}
	public Page<GoodsType> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return goodsTypeRepository.findAll(pageable);
	}
	public List<GoodsType> findAll(){
		return goodsTypeRepository.findAll();
	}
}
