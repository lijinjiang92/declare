package com.dspsemi.declare.backend.controller.test;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


public class CrmDisStoreUpdateReqDto implements Serializable {
	
	private static final long serialVersionUID = -1252539780756564155L;

	/**
	 * 发卡门店ID
	 */
	private UUID storeId;
	
	/**
	 * 禁用门店ID
	 */
	private List<UUID> newDisStoreId;
	
	
	public UUID getStoreId() {
		return storeId;
	}
	public void setStoreId(UUID storeId) {
		this.storeId = storeId;
	}
	public List<UUID> getNewDisStoreId() {
		return newDisStoreId;
	}
	public void setNewDisStoreId(List<UUID> newDisStoreId) {
		this.newDisStoreId = newDisStoreId;
	}
	

	
	

	
}
