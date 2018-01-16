package com.sullay.Client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sullay.model.Goods;
import com.sullay.model.Msg;

@FeignClient("IM-server")
@RequestMapping("/goods")
public interface GoodsClient {
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Goods goods);
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Goods goods);
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Goods goods);
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(int page,int size);
}
