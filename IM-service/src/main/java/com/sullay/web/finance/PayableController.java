package com.sullay.web.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.finance.Payable;
import com.sullay.service.finance.PayableService;

@RestController
@RequestMapping("/payable")
public class PayableController {
	@Autowired
	PayableService payableService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Payable payable) {
		payableService.create(payable);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Payable payable) {
		payableService.detele(payable);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Payable payable) {
		payableService.update(payable);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", payableService.findAll(page, size));
	}
}
