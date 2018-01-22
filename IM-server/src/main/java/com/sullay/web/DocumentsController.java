package com.sullay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Documents;
import com.sullay.model.Msg;
import com.sullay.service.DocumentsService;

@RestController
@RequestMapping("/documents")
public class DocumentsController {
	@Autowired
	DocumentsService documentsService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Documents documents) {
		documentsService.create(documents);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody Documents documents) {
		documentsService.detele(documents);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Documents documents) {
		documentsService.update(documents);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll() {
		return Msg.success().add("pageInfo", documentsService.findAll());
	}
}
