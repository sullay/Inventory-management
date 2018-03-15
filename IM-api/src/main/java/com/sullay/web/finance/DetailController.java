package com.sullay.web.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.client.finance.DetailClient;
import com.sullay.model.Msg;
import com.sullay.model.finance.Detail;

@RestController
@RequestMapping("/detailAPI")
public class DetailController {
	@Autowired
	DetailClient detailClient;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Detail detail) {
		detailClient.create(detail);
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Detail detail) {
		detailClient.detele(detail);
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Detail detail) {
		detailClient.update(detail);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return detailClient.findAll(page, size);
	}
}
