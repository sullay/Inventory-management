package com.sullay.repository.finance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sullay.model.finance.Daily;

public interface DailyRepository extends JpaRepository<Daily, Integer>{

}