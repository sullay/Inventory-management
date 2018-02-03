package com.sullay.client.other;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sullay.model.Msg;
import com.sullay.model.other.Transfer;

@FeignClient("IM-service")
@RequestMapping("/transfer")
public interface TransferClient {
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Transfer transfer);
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Transfer transfer);
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Transfer transfer);
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size);
}
