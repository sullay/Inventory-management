package com.sullay.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sullay.model.Msg;
import com.sullay.model.Unit;

@FeignClient("IM-service")
@RequestMapping("/unit")
public interface UnitClient {
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Unit unit);
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Unit unit);
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Unit unit);
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size);
	@RequestMapping(value="/all_NoPage",method=RequestMethod.GET)
	public Msg findAll();
}
