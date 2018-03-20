package com.sullay.web.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.client.finance.ReceivableClient;
import com.sullay.model.Msg;

@RestController
@RequestMapping("/receivableAPI")
public class ReceivableController {
	@Autowired
	ReceivableClient receivableClient;
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return receivableClient.findAll(page, size);
	}
}
