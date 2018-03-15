package com.sullay.web.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.client.finance.DailyClient;
import com.sullay.model.Msg;
import com.sullay.model.finance.Daily;

@RestController
@RequestMapping("dailyAPI")
public class DailyController {
	@Autowired
	DailyClient dailyClient;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Daily daily) {
		dailyClient.create(daily);
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Daily daily) {
		dailyClient.detele(daily);
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Daily daily) {
		dailyClient.update(daily);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return dailyClient.findAll(page, size);
	}
}
