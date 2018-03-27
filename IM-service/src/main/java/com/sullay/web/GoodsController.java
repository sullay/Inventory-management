package com.sullay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sullay.model.Goods;
import com.sullay.model.Msg;
import com.sullay.service.GoodsService;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	GoodsService goodsService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Goods goods) {
		goodsService.create(goods);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Goods goods) {
		goodsService.detele(goods);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Goods goods) {
		goodsService.update(goods);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", goodsService.findAll(page, size));
	}
	@RequestMapping(value="/all_NoPage",method=RequestMethod.GET)
	public Msg findAll() {
		return Msg.success().add("pageInfo", goodsService.findAll());
	}
}
