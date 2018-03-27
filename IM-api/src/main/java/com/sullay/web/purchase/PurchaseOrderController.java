package com.sullay.web.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.client.purchase.PurchaseOrderClient;
import com.sullay.model.Msg;
import com.sullay.model.purchase.PurchaseOrder;

@RestController
@RequestMapping("/purchaseOrderAPI")
public class PurchaseOrderController {
	@Autowired
	PurchaseOrderClient purchaseOrderClient;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody PurchaseOrder purchaseOrder) {
		purchaseOrderClient.create(purchaseOrder);
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody PurchaseOrder purchaseOrder) {
		purchaseOrderClient.detele(purchaseOrder);
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody PurchaseOrder purchaseOrder) {
		purchaseOrderClient.update(purchaseOrder);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return purchaseOrderClient.findAll(page, size);
	}
}
