package com.sullay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sullay.model.Documents;
import com.sullay.repository.DocumentsRepository;

@Service
public class DocumentsService {
	@Autowired
	DocumentsRepository documentsRepository;
	public void create(Documents documents){
		documentsRepository.save(documents);
	}
	public void detele(Documents documents){
		documentsRepository.delete(documents);
	}
	public void update(Documents documents){
		documentsRepository.save(documents);
	}
	public List<Documents> findAll(){
		return documentsRepository.findAll();
	}
}
