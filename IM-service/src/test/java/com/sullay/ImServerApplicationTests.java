package com.sullay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sullay.model.Goods;
import com.sullay.model.GoodsType;
import com.sullay.model.Stock;
import com.sullay.model.Unit;
import com.sullay.model.Warehouse;
import com.sullay.repository.GoodsRepository;
import com.sullay.repository.GoodsTypeRepository;
import com.sullay.repository.StockRepository;
import com.sullay.repository.UnitRepository;
import com.sullay.repository.WarehouseRepository;
import com.sullay.service.UnitService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImServerApplicationTests {
	@Autowired
	StockRepository stockRepository;
	@Autowired
	WarehouseRepository warehouseRepository;
	@Autowired
	UnitRepository unitRepository;
	@Autowired
	GoodsRepository goodsRepository;
	@Autowired
	GoodsTypeRepository goodsTypeRepository;
	@Autowired
	UnitService unitService;
	@Test
	public void test01() {
		Stock stock = new Stock();
		stock.setNumber(100);
		stock.setGoods(goodsRepository.findOne(1));
		stock.setWarehouse(warehouseRepository.findOne(1));
		stockRepository.save(stock);
	}
	@Test
	public void test02() {
		
		Warehouse warehouse=new Warehouse();
		warehouse.setCode("ZZZ");
		warehouse.setName("ZZZ");
		warehouse.setPlace("上海");
		warehouse.setExtend("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		warehouseRepository.save(warehouse);
	}
	@Test
	public void test03() {
		Unit unit=new Unit();
		unit.setCode("kg");
		unit.setDescription("千克");
		unitRepository.save(unit);
	}
	@Test
	public void test04() {
		GoodsType goodsType=new GoodsType();
		goodsType.setCode("XXX");
		goodsType.setCodingPrefix("xxx");
		goodsType.setName("XXX");
		goodsTypeRepository.save(goodsType);
	}
	@Test
	public void test05() {
		Goods goods=new Goods();
		goods.setGoodsType(goodsTypeRepository.findOne(1));
		goods.setCode("23456");
		goods.setBrand("xxx");
		goods.setName("xxx");
		goods.setPrice(10.0);
		goods.setSpecification("10*123");
		goods.setUnit(unitRepository.findOne(1));
		goodsRepository.save(goods);
	}
	@Test
	public void test06() {
		Unit unit = new Unit();
		unit.setId(1);
		unitRepository.delete(unit);
	}
	@Test
	public void test07() {
		Stock stock = stockRepository.findByGoodsIdAndWarehouseId(1, 1);
		System.out.println(stock.getGoods().getName()+stock.getWarehouse().getName());
	}
}
