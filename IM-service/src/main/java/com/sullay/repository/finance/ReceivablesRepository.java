package com.sullay.repository.finance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sullay.model.finance.Receivables;

public interface ReceivablesRepository extends JpaRepository<Receivables, Integer>{

}