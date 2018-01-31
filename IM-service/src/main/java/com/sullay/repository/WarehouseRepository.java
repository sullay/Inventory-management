package com.sullay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sullay.model.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

}
