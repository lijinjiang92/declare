package com.dspsemi.declare.backend.controller.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class ScmOrderTempletReqDto {
	
	private UUID id;
	
	private UUID storeId;
	
	private String tempCode;
	
	private String tempName;
	
	private Integer totalQty;
	
	private Integer status;
	
	private UUID createUser;
	
	private UUID updateUser;
	
	private Date createTime;
	
	private Date updateTime;
	
	private BigDecimal totalAmt;
	
	private List<ScmOrderTempletDetail> list;
	
	private List<UUID> delIdsList;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public UUID getStoreId() {
		return storeId;
	}

	public void setStoreId(UUID storeId) {
		this.storeId = storeId;
	}

	public UUID getCreateUser() {
		return createUser;
	}

	public void setCreateUser(UUID createUser) {
		this.createUser = createUser;
	}

	public UUID getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(UUID updateUser) {
		this.updateUser = updateUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public List<ScmOrderTempletDetail> getList() {
		return list;
	}

	public void setList(List<ScmOrderTempletDetail> list) {
		this.list = list;
	}

	public List<UUID> getDelIdsList() {
		return delIdsList;
	}

	public void setDelIdsList(List<UUID> delIdsList) {
		this.delIdsList = delIdsList;
	}
	
	public BigDecimal getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}

	public ScmOrderTemplet copyToScmOrderTemplet(){
		ScmOrderTemplet sot = new ScmOrderTemplet();
		sot.setId(getId());
		sot.setStoreId(getStoreId());
		sot.setTempCode(getTempCode());
		sot.setTempName(getTempName());
		sot.setTotalQty(getTotalQty());
		sot.setStatus(getStatus());
		return sot;
	}
	
}
