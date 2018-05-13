package com.sullay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.Goods;
import com.sullay.repository.GoodsRepository;
import com.sullay.repository.GoodsTypeRepository;

@Service
public class GoodsService {
	@Autowired
	GoodsRepository goodsRepository;
	@Autowired
	GoodsTypeRepository goodsTypeRepository;
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
	public List<Goods> findAll(){
		return goodsRepository.findAll();
	}
	public Page<Goods> search(int page,int size,String goodsName,int goodsTypeId,String brand){
		Pageable pageable = new PageRequest(page, size);
		if("".equals(brand)&&"".equals(goodsName)&&goodsTypeId==0) {
			return goodsRepository.findAll(pageable);
		}else if("".equals(brand)&&"".equals(goodsName)&&goodsTypeId!=0) {
			return goodsRepository.search(pageable, goodsTypeId);
		}else if("".equals(brand)&&!"".equals(goodsName)&&goodsTypeId==0) {
			return goodsRepository.searchName(pageable, goodsName);
		}else if(!"".equals(brand)&&"".equals(goodsName)&&goodsTypeId==0) {
			return goodsRepository.searchBrand(pageable, brand);
		}else if(!"".equals(brand)&&!"".equals(goodsName)&&goodsTypeId==0) {
			return goodsRepository.search(pageable, goodsName, brand);
		}else if(!"".equals(brand)&&"".equals(goodsName)&&goodsTypeId!=0) {
			return goodsRepository.search(pageable, goodsTypeId, brand);
		}else if ("".equals(brand)&&!"".equals(goodsName)&&goodsTypeId!=0) {
			return goodsRepository.search(pageable, goodsName, goodsTypeId);
		}else {
			return goodsRepository.search(pageable, goodsName, goodsTypeId, brand);
		}
	}
}
