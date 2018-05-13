package com.sullay.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sullay.model.Goods;
import com.sullay.model.Msg;

@FeignClient("IM-service")
@RequestMapping("/goods")
public interface GoodsClient {
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Goods goods);
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Goods goods);
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Goods goods);
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size);
	@RequestMapping(value="/all_NoPage",method=RequestMethod.GET)
	public Msg findAll();
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public Msg search(@RequestParam("page")int page,@RequestParam("size")int size,@RequestParam(name="goodsName",required=false)String goodsName,@RequestParam(name="goodsTypeId",required=false)int goodsTypeId,@RequestParam(name="brand",required=false)String brand);
}
