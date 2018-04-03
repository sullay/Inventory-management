package com.sullay.web.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Msg;
import com.sullay.model.Stock;
import com.sullay.model.Water;
import com.sullay.model.purchase.PurchaseOrder;
import com.sullay.model.purchase.PurchaseReceipt;
import com.sullay.service.StockService;
import com.sullay.service.purchase.PurchaseOrderService;
import com.sullay.service.purchase.PurchaseReceiptService;

@RestController
@RequestMapping("/purchaseReceipt")
public class PurchaseReceiptController {
	@Autowired
	PurchaseReceiptService purchaseReceiptService;
	@Autowired
	PurchaseOrderService purchaseOrderService;
	@Autowired
	StockService stockService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody PurchaseReceipt purchaseReceipt) {
		PurchaseOrder purchaseOrder = purchaseOrderService.findById(purchaseReceipt.getPurchaseOrder().getId());
		purchaseReceipt.setPurchaseOrder(purchaseOrder);
		for (Water water : purchaseReceipt.getWaters()) {
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
		purchaseReceiptService.create(purchaseReceipt);
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void detele(@RequestBody PurchaseReceipt purchaseReceipt) {
		purchaseReceiptService.detele(purchaseReceipt);
				
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody PurchaseReceipt purchaseReceipt) {
		purchaseReceiptService.update(purchaseReceipt);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size) {
		return Msg.success().add("pageInfo", purchaseReceiptService.findAll(page, size));
	}
}
