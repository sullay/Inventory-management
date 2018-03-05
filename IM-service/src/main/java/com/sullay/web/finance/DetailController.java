package com.sullay.web.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.finance.Detail;
import com.sullay.service.finance.DetailService;

@RestController
@RequestMapping("/detail")
public class DetailController {
	@Autowired
	DetailService detailService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Detail detail) {
		detailService.create(detail);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Detail detail) {
		detailService.detele(detail);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Detail detail) {
		detailService.update(detail);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", detailService.findAll(page, size));
	}
}
