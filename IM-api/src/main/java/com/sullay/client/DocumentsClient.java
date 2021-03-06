package com.sullay.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sullay.model.Documents;
import com.sullay.model.Msg;

@FeignClient("IM-service")
@RequestMapping("/documents")
public interface DocumentsClient {
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Documents documents);
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Documents documents);
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Documents documents);
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll();
	@RequestMapping(value="/",method=RequestMethod.GET)
	public Msg findByName(@RequestParam("name")String name);
}
