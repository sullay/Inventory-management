package com.sullay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sullay.service.GoodsService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ImServerApplicationTests2 {
	@Autowired
	GoodsService goodsService;
	@Test
	public void test01() {
		
		System.out.println(goodsService.findAll(0, 5));
	}
}
