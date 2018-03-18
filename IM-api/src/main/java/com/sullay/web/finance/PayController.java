package com.sullay.web.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.client.finance.PayClient;
import com.sullay.model.Msg;
import com.sullay.model.finance.Pay;

@RestController
@RequestMapping("/payAPI")
public class PayController {
	@Autowired
	PayClient payClient;

	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Pay pay) {
		payClient.create(pay);
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Pay pay) {
		payClient.detele(pay);
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Pay pay) {
		payClient.update(pay);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return payClient.findAll(page, size);
	}
}
