package com.sullay.web.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.sale.SaleDelivery;
import com.sullay.service.sale.SaleDeliveryService;

@RestController
@RequestMapping("/saleDelivery")
public class SaleDeliveryController {
	@Autowired
	SaleDeliveryService saleDeliveryService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody SaleDelivery saleDelivery) {
		saleDeliveryService.create(saleDelivery);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody SaleDelivery saleDelivery) {
		saleDeliveryService.detele(saleDelivery);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody SaleDelivery saleDelivery) {
		saleDeliveryService.update(saleDelivery);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", saleDeliveryService.findAll(page, size));
	}
}
