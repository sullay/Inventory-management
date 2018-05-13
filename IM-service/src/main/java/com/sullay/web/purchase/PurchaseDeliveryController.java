package com.sullay.web.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.Stock;
import com.sullay.model.Water;
import com.sullay.model.purchase.PurchaseDelivery;
import com.sullay.model.purchase.PurchaseOrder;
import com.sullay.service.StockService;
import com.sullay.service.purchase.PurchaseDeliveryService;
import com.sullay.service.purchase.PurchaseOrderService;

@RestController
@RequestMapping("/purchaseDelivery")
public class PurchaseDeliveryController {
	@Autowired
	PurchaseDeliveryService purchaseDeliveryService;
	@Autowired
	PurchaseOrderService purchaseOrderService;
	@Autowired
	StockService stockService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody PurchaseDelivery purchaseDelivery) {
		PurchaseOrder purchaseOrder = purchaseOrderService.findById(purchaseDelivery.getPurchaseOrder().getId());
		purchaseDelivery.setPurchaseOrder(purchaseOrder);
		for (Water water : purchaseDelivery.getWaters()) {
			Stock stock = stockService.findOne(water.getStock().getId());
			stock.setNumber(stock.getNumber()-water.getDeliveryNum());
			water.setStock(stock);
		}
		purchaseDeliveryService.create(purchaseDelivery);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody PurchaseDelivery purchaseDelivery) {
		purchaseDeliveryService.detele(purchaseDelivery);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody PurchaseDelivery purchaseDelivery) {
		purchaseDeliveryService.update(purchaseDelivery);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", purchaseDeliveryService.findAll(page, size));
	}
}
