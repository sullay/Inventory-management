package com.sullay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sullay.client.UnitClient;
import com.sullay.model.Unit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImApiApplicationTests {
	@Autowired
	UnitClient unitClient;
	@Test
	public void test01() {
		Unit unit = new Unit();
		unit.setId(4);
		unitClient.detele(unit);
	}
}
