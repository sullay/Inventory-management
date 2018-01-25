package com.sullay.repository.sale;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sullay.model.sale.SaleReceipt;

public interface SaleReceiptRepository extends JpaRepository<SaleReceipt, Integer>{

}
