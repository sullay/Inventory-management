package com.sullay.web.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.other.Transfer;
import com.sullay.service.other.TransferService;

@RestController
@RequestMapping("/transfer")
public class TransferController {
	@Autowired
	TransferService transferService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Transfer transfer) {
		transferService.create(transfer);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Transfer transfer) {
		transferService.detele(transfer);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Transfer transfer) {
		transferService.update(transfer);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", transferService.findAll(page, size));
	}
}
