package com.sullay.web.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.finance.FinanceReceipt;
import com.sullay.service.finance.FinanceReceiptService;

@RestController
@RequestMapping("/financeReceipt")
public class FinanceReceiptController {
	@Autowired
	FinanceReceiptService financeReceiptService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody FinanceReceipt financeReceipt) {
		financeReceiptService.create(financeReceipt);	
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody FinanceReceipt financeReceipt) {
		financeReceiptService.detele(financeReceipt);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody FinanceReceipt financeReceipt) {
		financeReceiptService.update(financeReceipt);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", financeReceiptService.findAll(page, size));
	}
}
