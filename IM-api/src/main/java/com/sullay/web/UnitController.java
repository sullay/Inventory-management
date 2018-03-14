package com.sullay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.client.UnitClient;
import com.sullay.model.Msg;
import com.sullay.model.Unit;

@RestController
@RequestMapping("/unitAPI")
public class UnitController {
	@Autowired
	UnitClient unitClient;
	@GetMapping("/all")
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return unitClient.findAll(page, size);
	}
	@GetMapping("/all_NoPage")
	public Msg findAll() {
		return unitClient.findAll();
	}
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Unit unit) {
		unitClient.create(unit);
	}

	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Unit unit) {
		unitClient.detele(unit);
	}
}
