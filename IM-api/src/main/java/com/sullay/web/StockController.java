package com.sullay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.client.StockClient;
import com.sullay.model.Msg;

@RestController
@RequestMapping("/stockAPI")
public class StockController {
	@Autowired
	StockClient stockClient;
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return stockClient.findAll(page, size);
	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public Msg findByGoodsIdAndWarehouseId(@RequestParam("gid")int gid, @RequestParam("wid")int wid) {
		return stockClient.findByGoodsIdAndWarehouseId(gid, wid);
	}
	@RequestMapping(value="/warning",method=RequestMethod.GET)
	public Msg findWarning(@RequestParam("page")int page,@RequestParam("size")int size) {
		return stockClient.findWarning(page, size);
	}
}
