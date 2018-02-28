package com.sullay.repository.finance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sullay.model.finance.Payable;

public interface PayableRepository extends JpaRepository<Payable, Integer>{

}