package com.sullay.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sullay.model.Msg;
import com.sullay.model.Stock;

@FeignClient("IM-service")
@RequestMapping("/stock")
public interface StockClient {
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Stock stock);
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Stock stock);
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Stock stock);
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size);
	@RequestMapping(value="/listByGoods",method=RequestMethod.GET)
	public Msg findByGoodsId(@RequestParam("gid")int gid);
	@RequestMapping(value="/",method=RequestMethod.GET)
	public Msg findByGoodsIdAndWarehouseId(@RequestParam("gid")int gid, @RequestParam("wid")int wid);
	@RequestMapping(value="/warning",method=RequestMethod.GET)
	public Msg findWarning(@RequestParam("page")int page,@RequestParam("size")int size);
}
