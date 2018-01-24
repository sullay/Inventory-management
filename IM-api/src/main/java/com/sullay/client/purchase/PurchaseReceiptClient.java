package com.sullay.client.purchase;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sullay.model.Msg;
import com.sullay.model.purchase.PurchaseReceipt;

@FeignClient("IM-service")
@RequestMapping("/purchaseReceipt")
public interface PurchaseReceiptClient {
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody PurchaseReceipt purchaseReceipt);
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody PurchaseReceipt purchaseReceipt);
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody PurchaseReceipt purchaseReceipt);
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size);
}
