package com.sullay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.client.GoodsClient;
import com.sullay.model.Goods;
import com.sullay.model.Msg;

@RestController
@RequestMapping("/goodsAPI")
public class GoodsController {
	@Autowired
	GoodsClient goodsClient;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Goods goods) {
		goodsClient.create(goods);
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Goods goods) {
		goodsClient.detele(goods);
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Goods goods) {
		goodsClient.update(goods);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return goodsClient.findAll(page, size);
	}
}
