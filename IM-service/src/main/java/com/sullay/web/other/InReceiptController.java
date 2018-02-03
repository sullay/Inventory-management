package com.sullay.web.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.other.InReceipt;
import com.sullay.service.other.InReceiptService;

@RestController
@RequestMapping("/inReceipt")
public class InReceiptController {
	@Autowired
	InReceiptService inReceiptService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody InReceipt inReceipt) {
		inReceiptService.create(inReceipt);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody InReceipt inReceipt) {
		inReceiptService.detele(inReceipt);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody InReceipt inReceipt) {
		inReceiptService.update(inReceipt);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", inReceiptService.findAll(page, size));
	}
}
