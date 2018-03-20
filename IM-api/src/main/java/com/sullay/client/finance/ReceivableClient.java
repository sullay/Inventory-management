package com.sullay.client.finance;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sullay.model.Msg;
import com.sullay.model.finance.Receivable;

@FeignClient("IM-service")
@RequestMapping("/receivable")
public interface ReceivableClient {
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Receivable receivable);
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Receivable receivable);
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Receivable receivable);
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size);
}
