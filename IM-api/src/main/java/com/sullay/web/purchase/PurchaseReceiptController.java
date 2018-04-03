package com.sullay.web.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.client.purchase.PurchaseReceiptClient;
import com.sullay.model.Msg;
import com.sullay.model.purchase.PurchaseReceipt;

@RestController
@RequestMapping("/purchaseReceiptAPI")
public class PurchaseReceiptController {
	@Autowired
	PurchaseReceiptClient purchaseReceiptClient;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody PurchaseReceipt purchaseReceipt) {
		purchaseReceiptClient.create(purchaseReceipt);
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody PurchaseReceipt purchaseReceipt) {
		purchaseReceiptClient.detele(purchaseReceipt);
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody PurchaseReceipt purchaseReceipt) {
		purchaseReceiptClient.update(purchaseReceipt);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return purchaseReceiptClient.findAll(page, size);
	}
}
