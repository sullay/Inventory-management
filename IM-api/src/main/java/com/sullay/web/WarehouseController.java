package com.sullay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.client.WarehouseClient;
import com.sullay.model.Msg;
import com.sullay.model.Warehouse;

@RestController
@RequestMapping("/warehouseAPI")
public class WarehouseController {
	@Autowired
	WarehouseClient warehouseClient;
	@GetMapping("/all")
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return warehouseClient.findAll(page, size);
	}
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(Warehouse warehouse) {
		warehouseClient.create(warehouse);
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(Warehouse warehouse) {
		warehouseClient.detele(warehouse);
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(Warehouse warehouse) {
		warehouseClient.update(warehouse);
	}
}
