package com.sullay.Client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sullay.model.Msg;
import com.sullay.model.Stock;

@FeignClient("IM-server")
@RequestMapping("/stock")
public interface StockClient {
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Stock stock);
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Stock stock);
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Stock stock);
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(int page,int size);
}
