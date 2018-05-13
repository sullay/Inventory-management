package com.sullay.web.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.Stock;
import com.sullay.model.Water;
import com.sullay.model.sale.SaleOrder;
import com.sullay.model.sale.SaleReceipt;
import com.sullay.service.StockService;
import com.sullay.service.sale.SaleOrderService;
import com.sullay.service.sale.SaleReceiptService;

@RestController
@RequestMapping("/saleReceipt")
public class SaleReceiptController {
	@Autowired
	SaleReceiptService saleReceiptService;
	@Autowired
	SaleOrderService saleOrderService;
	@Autowired
	StockService stockService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody SaleReceipt saleReceipt) {
		SaleOrder SaleOrder = saleOrderService.findById(saleReceipt.getSaleOrder().getId());
		saleReceipt.setSaleOrder(SaleOrder);
		for (Water water : saleReceipt.getWaters()) {
			Stock stock = stockService.findByGoodsIdAndWarehouseId(water.getStock().getGoods().getId(), water.getStock().getWarehouse().getId());
			if(stock==null) {
				water.getStock().setNumber(water.getReceiptNum());
				stockService.create(water.getStock());
				stock = stockService.findByGoodsIdAndWarehouseId(water.getStock().getGoods().getId(), water.getStock().getWarehouse().getId());
			}else {
				stock.setNumber(stock.getNumber()+water.getReceiptNum());
			}
			water.setStock(stock);
		}
		saleReceiptService.create(saleReceipt);
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody SaleReceipt saleReceipt) {
		saleReceiptService.detele(saleReceipt);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody SaleReceipt saleReceipt) {
		saleReceiptService.update(saleReceipt);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", saleReceiptService.findAll(page, size));
	}
}
