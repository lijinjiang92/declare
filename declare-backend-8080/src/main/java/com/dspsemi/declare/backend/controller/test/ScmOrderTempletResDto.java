package com.dspsemi.declare.backend.controller.test;

import java.util.UUID;

public class ScmOrderTempletResDto {
	
	private UUID id;
	
	private String storeId;
	
	private String tempCode;
	
	private String tempName;
	
	private Integer totalQty;
	
	private String status;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTempCode() {
		return tempCode;
	}

	public void setTempCode(String tempCode) {
		this.tempCode = tempCode;
	}

	public String getTempName() {
		return tempName;
	}

	public void setTempName(String tempName) {
		this.tempName = tempName;
	}

	public Integer getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(Integer totalQty) {
		this.totalQty = totalQty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	
	
}
