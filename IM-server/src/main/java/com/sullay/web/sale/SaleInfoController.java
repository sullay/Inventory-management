package com.sullay.web.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.sale.SaleInfo;
import com.sullay.service.sale.SaleInfoService;

@RestController
@RequestMapping("/saleInfo")
public class SaleInfoController {
	@Autowired
	SaleInfoService saleInfoService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody SaleInfo saleInfo) {
		saleInfoService.create(saleInfo);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody SaleInfo saleInfo) {
		saleInfoService.detele(saleInfo);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody SaleInfo saleInfo) {
		saleInfoService.update(saleInfo);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", saleInfoService.findAll(page, size));
	}
}
