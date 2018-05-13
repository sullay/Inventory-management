package com.sullay.web.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.client.purchase.PurchaseDeliveryClient;
import com.sullay.model.Msg;
import com.sullay.model.purchase.PurchaseDelivery;

@RestController
@RequestMapping("/purchaseDeliveryAPI")
public class PurchaseDeliveryController {
	@Autowired
	PurchaseDeliveryClient purchaseDeliveryClient;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody PurchaseDelivery purchaseDelivery) {
		purchaseDeliveryClient.create(purchaseDelivery);
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody PurchaseDelivery purchaseDelivery) {
		purchaseDeliveryClient.detele(purchaseDelivery);
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody PurchaseDelivery purchaseDelivery) {
		purchaseDeliveryClient.update(purchaseDelivery);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return purchaseDeliveryClient.findAll(page, size);
	}
}
