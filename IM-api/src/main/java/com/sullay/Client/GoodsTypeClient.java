package com.sullay.Client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sullay.model.GoodsType;
import com.sullay.model.Msg;

@FeignClient("IM-server")
@RequestMapping("/goodsType")
public interface GoodsTypeClient {
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody GoodsType goodsType);
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody GoodsType goodsType);
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody GoodsType goodsType);
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(int page,int size);
}
