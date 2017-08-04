package com.dspsemi.declare.backend.controller.test;

import java.util.List;
import java.util.UUID;


public class CrmDisStoreGetReqDto{
	
	private static final long serialVersionUID = -1252539780756564155L;

	/**
	 * 发卡门店ID
	 */
	private UUID storeId;
	
	/**
	 * 禁用门店ID
	 */
	private List<UUID> disStoreId;
	
	
	public UUID getStoreId() {
		return storeId;
	}
	public void setStoreId(UUID storeId) {
		this.storeId = storeId;
	}
	public List<UUID> getDisStoreId() {
		return disStoreId;
	}
	public void setDisStoreId(List<UUID> disStoreId) {
		this.disStoreId = disStoreId;
	}
	

	
}
