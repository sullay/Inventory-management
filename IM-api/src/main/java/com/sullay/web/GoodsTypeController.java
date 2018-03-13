package com.sullay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.client.GoodsTypeClient;
import com.sullay.model.GoodsType;
import com.sullay.model.Msg;

@RestController
@RequestMapping("/goodsTypeAPI")
public class GoodsTypeController {
	@Autowired
	GoodsTypeClient goodsTypeClient;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(GoodsType goodsType) {
		goodsTypeClient.create(goodsType);
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(GoodsType goodsType) {
		goodsTypeClient.detele(goodsType);
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(GoodsType goodsType) {
		goodsTypeClient.update(goodsType);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return goodsTypeClient.findAll(page, size);
	}
}
