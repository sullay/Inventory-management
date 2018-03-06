package com.sullay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.client.UnitClient;
import com.sullay.model.Msg;

@RestController
@RequestMapping("/unitAPI")
public class UnitController {
	@Autowired
	UnitClient unitClient;
	@GetMapping("/all")
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return unitClient.findAll(page, size);
	}
}
