package com.dspsemi.declare.backend.controller.test;

import java.util.UUID;

public class ScmOrderTempletReqDetail {
	
	private UUID id;
	
	private UUID billId;
	
	private UUID goodsId;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getBillId() {
		return billId;
	}

	public void setBillId(UUID billId) {
		this.billId = billId;
	}

	public UUID getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(UUID goodsId) {
		this.goodsId = goodsId;
	}
	
}
