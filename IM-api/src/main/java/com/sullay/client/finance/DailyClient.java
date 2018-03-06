package com.sullay.client.finance;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sullay.model.Msg;
import com.sullay.model.finance.Daily;

@FeignClient("IM-service")
@RequestMapping("/daily")
public interface DailyClient {
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Daily daily);
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Daily daily);
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Daily daily);
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size);
}
