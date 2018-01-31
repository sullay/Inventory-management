package com.sullay.web.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.other.InDelivery;
import com.sullay.service.other.InDeliveryService;

@RestController
@RequestMapping("/inDelivery")
public class InDeliveryController {
	@Autowired
	InDeliveryService inDeliveryService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody InDelivery inDelivery) {
		inDeliveryService.create(inDelivery);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody InDelivery inDelivery) {
		inDeliveryService.detele(inDelivery);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody InDelivery inDelivery) {
		inDeliveryService.update(inDelivery);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", inDeliveryService.findAll(page, size));
	}
}
