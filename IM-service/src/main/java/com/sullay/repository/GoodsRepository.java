package com.sullay.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sullay.model.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {
	@Query("from Goods g where g.name like %:goodsName% and g.brand like %:brand% and g.goodsType.id=:goodsTypeId")
	public Page<Goods> search(Pageable pageable,@Param("goodsName")String goodsName,@Param("goodsTypeId")int goodsTypeId,@Param("brand")String brand);
	@Query("from Goods g where g.name like %:goodsName% and g.goodsType.id=:goodsTypeId")
	public Page<Goods> search(Pageable pageable,@Param("goodsName")String goodsName,@Param("goodsTypeId")int goodsTypeId);
	@Query("from Goods g where g.name like %:goodsName% and g.brand like %:brand%")
	public Page<Goods> search(Pageable pageable,@Param("goodsName")String goodsName,@Param("brand")String brand);
	@Query("from Goods g where g.brand like %:brand% and g.goodsType.id=:goodsTypeId")
	public Page<Goods> search(Pageable pageable,@Param("goodsTypeId")int goodsTypeId,@Param("brand")String brand);
	@Query("from Goods g where g.name like %:goodsName%")
	public Page<Goods> searchName(Pageable pageable,@Param("goodsName")String goodsName);
	@Query("from Goods g where g.goodsType.id=:goodsTypeId")
	public Page<Goods> search(Pageable pageable,@Param("goodsTypeId")int goodsTypeId);
	@Query("from Goods g where g.brand like %:brand%")
	public Page<Goods> searchBrand(Pageable pageable,@Param("brand")String brand);
}
