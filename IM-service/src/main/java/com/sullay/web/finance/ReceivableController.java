package com.sullay.web.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.finance.Receivable;
import com.sullay.service.finance.ReceivableService;

@RestController
@RequestMapping("/receivable")
public class ReceivableController {
	@Autowired
	ReceivableService receivableService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Receivable receivable) {
		receivableService.create(receivable);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Receivable receivable) {
		receivableService.detele(receivable);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Receivable receivable) {
		receivableService.update(receivable);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", receivableService.findAll(page, size));
	}
}
