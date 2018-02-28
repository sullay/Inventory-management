package com.sullay.repository.finance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sullay.model.finance.Pay;

public interface PayRepository extends JpaRepository<Pay, Integer>{

}