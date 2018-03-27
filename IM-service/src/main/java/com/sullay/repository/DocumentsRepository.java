package com.sullay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sullay.model.Documents;

public interface DocumentsRepository extends JpaRepository<Documents, Integer> {
	public Documents findByName(String name);
}
