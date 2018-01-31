package com.sullay.web.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.sale.SaleOrder;
import com.sullay.service.sale.SaleOrderService;

@RestController
@RequestMapping("/saleOrder")
public class SaleOrderController {
	@Autowired
	SaleOrderService saleOrderService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody SaleOrder saleOrder) {
		saleOrderService.create(saleOrder);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody SaleOrder saleOrder) {
		saleOrderService.detele(saleOrder);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody SaleOrder saleOrder) {
		saleOrderService.update(saleOrder);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageOrder", saleOrderService.findAll(page, size));
	}
}
