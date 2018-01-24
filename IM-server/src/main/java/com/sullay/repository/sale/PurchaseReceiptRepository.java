package com.sullay.repository.sale;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sullay.model.purchase.PurchaseReceipt;

public interface PurchaseReceiptRepository extends JpaRepository<PurchaseReceipt, Integer>{

}
