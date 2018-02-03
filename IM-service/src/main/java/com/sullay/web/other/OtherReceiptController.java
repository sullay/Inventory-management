package com.sullay.web.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.other.OtherReceipt;
import com.sullay.service.other.OtherReceiptService;

@RestController
@RequestMapping("/otherReceipt")
public class OtherReceiptController {
	@Autowired
	OtherReceiptService otherReceiptService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody OtherReceipt otherReceipt) {
		otherReceiptService.create(otherReceipt);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody OtherReceipt otherReceipt) {
		otherReceiptService.detele(otherReceipt);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody OtherReceipt otherReceipt) {
		otherReceiptService.update(otherReceipt);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", otherReceiptService.findAll(page, size));
	}
}
