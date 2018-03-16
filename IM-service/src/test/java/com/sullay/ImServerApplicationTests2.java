package com.sullay;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sullay.model.Documents;
import com.sullay.model.finance.Detail;
import com.sullay.model.finance.FinanceReceipt;
import com.sullay.model.finance.Pay;
import com.sullay.model.finance.Payable;
import com.sullay.model.finance.Payable.State;
import com.sullay.model.finance.Receivables;
import com.sullay.service.DocumentsService;
import com.sullay.service.GoodsService;
import com.sullay.service.UnitService;
import com.sullay.service.finance.FinanceReceiptService;
import com.sullay.service.finance.PayService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ImServerApplicationTests2 {
	@Autowired
	GoodsService goodsService;
	@Autowired
	DocumentsService documentsService;
	@Autowired
	UnitService unitService;
	@Autowired
	PayService payService;
	@Autowired
	FinanceReceiptService financeReceiptService;
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
	@Test
	public void test03() {
		Payable payable = new Payable();
		payable.setAmountPaid(1.0);
		payable.setCode("2");
		payable.setExtend("1");
		payable.setState(State.INCOMPLETE);
		payable.setAmount(12.0);
		Pay pay = new Pay();
		pay.setDate(new Date());
		pay.setExtend("1");
		pay.setAmount(1.0);
		pay.setPayable(payable);
		Detail detail = new Detail();
		detail.setCode(pay.getPayable().getCode());
		detail.setDate(new Date());
		detail.setExtend("1");
		detail.setPay(pay.getAmount());
		detail.setTrader("1");
		detail.setType("付款");
		pay.setDetail(detail);
		payService.create(pay);
	}
	@Test
	public void test04() {
		Receivables receivables = new Receivables();
		receivables.setAmountReceived(1.0);
		receivables.setCode("2");
		receivables.setExtend("1");
		receivables.setState(com.sullay.model.finance.Receivables.State.INCOMPLETE);
		receivables.setAmount(12.0);
		FinanceReceipt financeReceipt = new FinanceReceipt();
		financeReceipt.setDate(new Date());
		financeReceipt.setExtend("1");
		financeReceipt.setAmount(1.0);
		financeReceipt.setReceivables(receivables);
		Detail detail = new Detail();
		detail.setCode(financeReceipt.getReceivables().getCode());
		detail.setDate(new Date());
		detail.setExtend("1");
		detail.setIncome(financeReceipt.getAmount());
		detail.setTrader("1");
		detail.setType("付款");
		financeReceipt.setDetail(detail);
		financeReceiptService.create(financeReceipt);
	}
}
