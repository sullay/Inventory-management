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
import com.sullay.model.sale.SaleOrder;
import com.sullay.model.sale.SaleOrder.State;
import com.sullay.repository.GoodsRepository;
import com.sullay.repository.GoodsTypeRepository;
import com.sullay.repository.StockRepository;
import com.sullay.repository.UnitRepository;
import com.sullay.repository.WarehouseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImServerApplicationTests3 {
	@Test
	public void test() {
		SaleOrder order = new SaleOrder();
		order.setState(State);
	}
}
