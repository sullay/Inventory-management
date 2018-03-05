package com.sullay.web.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.finance.Receivables;
import com.sullay.service.finance.ReceivablesService;

@RestController
@RequestMapping("/receivables")
public class ReceivablesController {
	@Autowired
	ReceivablesService receivablesService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Receivables receivables) {
		receivablesService.create(receivables);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Receivables receivables) {
		receivablesService.detele(receivables);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Receivables receivables) {
		receivablesService.update(receivables);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", receivablesService.findAll(page, size));
	}
}
