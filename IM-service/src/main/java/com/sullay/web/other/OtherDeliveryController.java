package com.sullay.web.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.other.OtherDelivery;
import com.sullay.service.other.OtherDeliveryService;

@RestController
@RequestMapping("/OtherDelivery")
public class OtherDeliveryController {
	@Autowired
	OtherDeliveryService otherDeliveryService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody OtherDelivery otherDelivery) {
		otherDeliveryService.create(otherDelivery);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody OtherDelivery otherDelivery) {
		otherDeliveryService.detele(otherDelivery);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody OtherDelivery otherDelivery) {
		otherDeliveryService.update(otherDelivery);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", otherDeliveryService.findAll(page, size));
	}
}
