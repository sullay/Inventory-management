package com.sullay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.client.UnitClient;

@RestController
public class UnitController {
	@Autowired
	UnitClient unitClient;
}
