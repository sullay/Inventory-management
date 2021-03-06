package com.sullay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.Water;
import com.sullay.service.WaterService;

@RestController
@RequestMapping("/water")
public class WaterController {
	@Autowired
	WaterService waterService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Water water) {
		waterService.create(water);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Water water) {
		waterService.detele(water);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Water water) {
		waterService.update(water);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", waterService.findAll(page, size));
	}
}
