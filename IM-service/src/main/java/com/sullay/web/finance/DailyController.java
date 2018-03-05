package com.sullay.web.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.finance.Daily;
import com.sullay.service.finance.DailyService;

@RestController
@RequestMapping("/daily")
public class DailyController {
	@Autowired
	DailyService dailyService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Daily daily) {
		dailyService.create(daily);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Daily daily) {
		dailyService.detele(daily);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Daily daily) {
		dailyService.update(daily);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", dailyService.findAll(page, size));
	}
}
