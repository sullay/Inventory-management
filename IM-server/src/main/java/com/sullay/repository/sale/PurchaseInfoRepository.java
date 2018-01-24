package com.sullay.repository.sale;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sullay.model.purchase.PurchaseInfo;

public interface PurchaseInfoRepository extends JpaRepository<PurchaseInfo, Integer>{

}
