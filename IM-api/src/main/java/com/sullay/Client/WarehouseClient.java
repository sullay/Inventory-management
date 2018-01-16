package com.sullay.Client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sullay.model.Msg;
import com.sullay.model.Warehouse;

@FeignClient("IM-server")
@RequestMapping("/warehouse")
public interface WarehouseClient {
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Warehouse warehouse);
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Warehouse warehouse);
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Warehouse warehouse);
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(int page,int size);
}
