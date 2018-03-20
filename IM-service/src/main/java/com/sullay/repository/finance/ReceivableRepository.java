package com.sullay.repository.finance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sullay.model.finance.Receivable;

public interface ReceivableRepository extends JpaRepository<Receivable, Integer>{

}