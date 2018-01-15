package com.sullay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sullay.model.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {

}
