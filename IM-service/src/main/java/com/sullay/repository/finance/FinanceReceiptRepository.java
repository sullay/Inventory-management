package com.sullay.repository.finance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sullay.model.finance.FinanceReceipt;

public interface FinanceReceiptRepository extends JpaRepository<FinanceReceipt, Integer>{

}