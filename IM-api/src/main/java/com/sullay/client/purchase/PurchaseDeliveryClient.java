package com.sullay.client.purchase;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sullay.model.Msg;
import com.sullay.model.purchase.PurchaseDelivery;

@FeignClient("IM-service")
@RequestMapping("/purchaseDelivery")
public interface PurchaseDeliveryClient {
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody PurchaseDelivery purchaseDelivery);
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody PurchaseDelivery purchaseDelivery);
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody PurchaseDelivery purchaseDelivery);
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size);
}
