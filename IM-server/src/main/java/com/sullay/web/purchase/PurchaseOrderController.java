package com.sullay.web.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.purchase.PurchaseOrder;
import com.sullay.service.purchase.PurchaseOrderService;

@RestController
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController {
	@Autowired
	PurchaseOrderService purchaseOrderService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody PurchaseOrder purchaseOrder) {
		purchaseOrderService.create(purchaseOrder);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody PurchaseOrder purchaseOrder) {
		purchaseOrderService.detele(purchaseOrder);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody PurchaseOrder purchaseOrder) {
		purchaseOrderService.update(purchaseOrder);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageOrder", purchaseOrderService.findAll(page, size));
	}
}
