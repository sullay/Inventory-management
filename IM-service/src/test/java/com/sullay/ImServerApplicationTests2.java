package com.sullay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sullay.model.Documents;
import com.sullay.model.Unit;
import com.sullay.service.DocumentsService;
import com.sullay.service.GoodsService;
import com.sullay.service.UnitService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ImServerApplicationTests2 {
	@Autowired
	GoodsService goodsService;
	@Autowired
	DocumentsService documentsService;
	@Autowired
	UnitService unitService;
	@Test
	public void test01() {
		
	}
	@Test
	public void test02() {
		Documents documents01=new Documents();
		documents01.setName("采购订单");
		documents01.setPrefix("CG");
		documentsService.create(documents01);
		Documents documents02=new Documents();
		documents02.setName("采购入库单");
		documents02.setPrefix("CRK");
		documentsService.create(documents02);
		Documents documents03=new Documents();
		documents03.setName("采购退货单");
		documents03.setPrefix("CTH");
		documentsService.create(documents03);

		Documents documents04=new Documents();
		documents04.setName("销售订单");
		documents04.setPrefix("XS");
		documentsService.create(documents04);

		Documents documents05=new Documents();
		documents05.setName("销售入库单");
		documents05.setPrefix("XRK");
		documentsService.create(documents05);

		Documents documents06=new Documents();
		documents06.setName("销售出库单");
		documents06.setPrefix("XCK");
		documentsService.create(documents06);

		Documents documents07=new Documents();
		documents07.setName("转仓单");
		documents07.setPrefix("ZC");
		documentsService.create(documents07);

		Documents documents08=new Documents();
		documents08.setName("内部领用单");
		documents08.setPrefix("NLY");
		documentsService.create(documents08);

		Documents documents09=new Documents();
		documents09.setName("内部退返单");
		documents09.setPrefix("NTF");
		documentsService.create(documents09);

		Documents documents10=new Documents();
		documents10.setName("其他入库单");
		documents10.setPrefix("QRK");
		documentsService.create(documents10);

		Documents documents11=new Documents();
		documents11.setName("其他出库单");
		documents11.setPrefix("QCK");
		documentsService.create(documents11);
		
	}
}
