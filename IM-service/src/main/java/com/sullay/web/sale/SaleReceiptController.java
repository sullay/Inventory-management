package com.sullay.web.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.sale.SaleReceipt;
import com.sullay.service.sale.SaleReceiptService;

@RestController
@RequestMapping("/saleReceipt")
public class SaleReceiptController {
	@Autowired
	SaleReceiptService saleReceiptService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody SaleReceipt saleReceipt) {
		saleReceiptService.create(saleReceipt);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody SaleReceipt saleReceipt) {
		saleReceiptService.detele(saleReceipt);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody SaleReceipt saleReceipt) {
		saleReceiptService.update(saleReceipt);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", saleReceiptService.findAll(page, size));
	}
}
