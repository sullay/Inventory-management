package com.sullay.web.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.purchase.PurchaseInfo;
import com.sullay.service.purchase.PurchaseInfoService;

@RestController
@RequestMapping("/purchaseInfo")
public class PurchaseInfoController {
	@Autowired
	PurchaseInfoService purchaseInfoService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody PurchaseInfo purchaseInfo) {
		purchaseInfoService.create(purchaseInfo);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody PurchaseInfo purchaseInfo) {
		purchaseInfoService.detele(purchaseInfo);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody PurchaseInfo purchaseInfo) {
		purchaseInfoService.update(purchaseInfo);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", purchaseInfoService.findAll(page, size));
	}
}
