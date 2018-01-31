package com.sullay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sullay.model.Water;

public interface WaterRepository extends JpaRepository<Water, Integer> {

}
