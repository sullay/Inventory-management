package com.sullay.web.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.Stock;
import com.sullay.model.Water;
import com.sullay.model.sale.SaleDelivery;
import com.sullay.model.sale.SaleOrder;
import com.sullay.service.StockService;
import com.sullay.service.sale.SaleDeliveryService;
import com.sullay.service.sale.SaleOrderService;

@RestController
@RequestMapping("/saleDelivery")
public class SaleDeliveryController {
	@Autowired
	SaleDeliveryService saleDeliveryService;
	@Autowired
	SaleOrderService saleOrderService;
	@Autowired
	StockService stockService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody SaleDelivery saleDelivery) {
		SaleOrder saleOrder = saleOrderService.findById(saleDelivery.getSaleOrder().getId());
		saleDelivery.setSaleOrder(saleOrder);
		for (Water water : saleDelivery.getWaters()) {
			Stock stock = stockService.findOne(water.getStock().getId());
			stock.setNumber(stock.getNumber()-water.getDeliveryNum());
			water.setStock(stock);
		}
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
