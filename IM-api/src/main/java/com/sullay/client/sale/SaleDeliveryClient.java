package com.sullay.client.sale;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sullay.model.Msg;
import com.sullay.model.sale.SaleDelivery;

@FeignClient("IM-service")
@RequestMapping("/saleDelivery")
public interface SaleDeliveryClient {
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody SaleDelivery saleDelivery);
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody SaleDelivery saleDelivery);
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody SaleDelivery saleDelivery);
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size);
}
