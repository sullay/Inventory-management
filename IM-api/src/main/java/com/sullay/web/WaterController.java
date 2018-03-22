package com.sullay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.client.WaterClient;
import com.sullay.model.Msg;
import com.sullay.model.Water;

@RestController
@RequestMapping("/waterAPI")
public class WaterController {
	@Autowired
	WaterClient waterClient;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Water water) {
		waterClient.create(water);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Water water) {
		waterClient.detele(water);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Water water) {
		waterClient.update(water);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return waterClient.findAll(page, size);
	}
}
