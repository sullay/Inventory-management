package com.sullay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.GoodsType;
import com.sullay.model.Msg;
import com.sullay.service.GoodsTypeService;

@RestController
@RequestMapping("/goodsType")
public class GoodsTypeController {
	@Autowired
	GoodsTypeService goodsTypeService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody GoodsType goodsType) {
		goodsTypeService.create(goodsType);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody GoodsType goodsType) {
		goodsTypeService.detele(goodsType);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody GoodsType goodsType) {
		goodsTypeService.update(goodsType);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(int page,int size) {
		return Msg.success().add("pageInfo", goodsTypeService.findAll(page, size));
	}
}
