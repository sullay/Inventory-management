package com.sullay;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sullay.client.UnitClient;
import com.sullay.client.finance.DetailClient;
import com.sullay.model.Unit;
import com.sullay.model.finance.Detail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImApiApplicationTests {
	@Autowired
	UnitClient unitClient;
	@Autowired
	DetailClient detailClient;
	@Test
	public void test01() {
		Unit unit = new Unit();
		unit.setId(4);
		unitClient.detele(unit);
	}
	@Test
	public void test02() {
		Detail detail=new Detail();
		detail.setCode("1");
		detail.setDate(new Date());
		detail.setExtend("1");
		detail.setId(0);
		detail.setIncome(10.0);
		detail.setPay(0.0);
		detail.setTrader("1");
		detail.setType("1");
		detailClient.create(detail);
	}
}
