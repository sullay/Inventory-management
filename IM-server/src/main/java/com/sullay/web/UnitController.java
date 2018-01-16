package com.sullay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.Unit;
import com.sullay.service.UnitService;

@RestController
@RequestMapping("/unit")
public class UnitController {
	@Autowired
	UnitService unitService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Unit unit) {
		unitService.create(unit);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Unit unit) {
		unitService.detele(unit);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Unit unit) {
		unitService.update(unit);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(int page,int size) {
		return Msg.success().add("pageInfo", unitService.findAll(page, size));
	}
}
