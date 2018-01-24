package com.sullay.repository.sale;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sullay.model.purchase.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer>{

}
