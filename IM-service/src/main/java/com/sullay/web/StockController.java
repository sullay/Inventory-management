package com.sullay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.Stock;
import com.sullay.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {
	@Autowired
	StockService stockService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Stock stock) {
		stockService.create(stock);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Stock stock) {
		stockService.detele(stock);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Stock stock) {
		stockService.update(stock);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", stockService.findAll(page, size));
	}
	@RequestMapping(value="/listByGoods",method=RequestMethod.GET)
	public Msg findByGoodsId(@RequestParam("gid")int gid){
		return Msg.success().add("pageInfo", stockService.findByGoodsId(gid));
	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public Msg findByGoodsIdAndWarehouseId(@RequestParam("gid")int gid, @RequestParam("wid")int wid) {
		return Msg.success().add("pageInfo", stockService.findByGoodsIdAndWarehouseId(gid, wid));
	}
	@RequestMapping(value="/warning",method=RequestMethod.GET)
	public Msg findWarning(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", stockService.findWarning(page, size));
	}
}
