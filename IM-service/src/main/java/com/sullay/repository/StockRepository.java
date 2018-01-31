package com.sullay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sullay.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

}
