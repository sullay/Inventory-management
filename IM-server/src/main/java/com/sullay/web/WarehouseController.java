package com.sullay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.Warehouse;
import com.sullay.service.WarehouseService;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
	@Autowired
	WarehouseService warehouseService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Warehouse warehouse) {
		warehouseService.create(warehouse);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Warehouse warehouse) {
		warehouseService.detele(warehouse);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Warehouse warehouse) {
		warehouseService.update(warehouse);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(int page,int size) {
		return Msg.success().add("pageInfo", warehouseService.findAll(page, size));
	}
}
