package com.sullay.repository.finance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sullay.model.finance.Detail;

public interface DetailRepository extends JpaRepository<Detail, Integer>{

}