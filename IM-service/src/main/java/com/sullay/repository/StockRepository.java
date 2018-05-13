package com.sullay.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sullay.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {
	public List<Stock> findByGoodsId(int gid);
	public Stock findByGoodsIdAndWarehouseId(int gid,int wid);
	@Query("from Stock s where s.number>s.goods.max or s.number<s.goods.min")
	public Page<Stock> findWarning(Pageable pageable);
}
