package com.sullay.web.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.client.sale.SaleReceiptClient;
import com.sullay.model.Msg;
import com.sullay.model.sale.SaleReceipt;

@RestController
@RequestMapping("/saleReceiptAPI")
public class SaleReceiptController {
	@Autowired
	SaleReceiptClient saleReceiptClient;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody SaleReceipt saleReceipt) {
		saleReceiptClient.create(saleReceipt);
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody SaleReceipt saleReceipt) {
		saleReceiptClient.detele(saleReceipt);
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody SaleReceipt saleReceipt) {
		saleReceiptClient.update(saleReceipt);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return saleReceiptClient.findAll(page, size);
	}
}
