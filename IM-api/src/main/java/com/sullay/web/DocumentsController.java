package com.sullay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.client.DocumentsClient;
import com.sullay.model.Documents;
import com.sullay.model.Msg;

@RestController
@RequestMapping("/documentsAPI")
public class DocumentsController {
	@Autowired
	DocumentsClient documentsClient;
	@GetMapping(value="/all")
	public Msg findAll() {
		return documentsClient.findAll();
	}
	@PutMapping("/")
	public void update(Documents documents) {
		documentsClient.update(documents);
	}
}
