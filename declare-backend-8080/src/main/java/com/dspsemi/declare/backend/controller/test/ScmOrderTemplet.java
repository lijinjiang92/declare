package com.dspsemi.declare.backend.controller.test;


import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ScmOrderTemplet{	
	//columns START
	//主键ID
	private java.util.UUID id;
	//机构标识
	private java.util.UUID storeId;
	//机构名称
	private java.lang.String storeName;
	//模板编号
	private java.lang.String tempCode;
	//模板名称
	private java.lang.String tempName;
	//订单类型 配销订货,客商订货
	private Integer orderType;
	//仓库ID
	private java.util.UUID depotId;
	//仓库名称
	private java.lang.String depotName;
	//供应商ID
	private java.util.UUID suppId;
	//供应商名称
	private java.lang.String suppName;
	//送货地址
	private java.lang.String shipAddress;
	//总计金额
	private BigDecimal totalAmt;
	//状态
	private Integer status;
	//创建人
	private java.util.UUID createUser;
	//创建时间
	private java.util.Date createTime;
	//修改人
	private java.util.UUID updateUser;
	//修改时间
	private java.util.Date updateTime;
	//备注
	private java.lang.String remarks;
	
	private Integer totalQty;
	//columns END
	
	/**
	 * 模板详情
	 */
	private List<ScmOrderTempletDetail> list;

	public void setId(java.util.UUID id) {
		this.id = id;
	}
	
	public java.util.UUID getId() {
		return this.id;
	}

	public void setStoreId(java.util.UUID storeId) {
		this.storeId = storeId;
	}
	
	public java.util.UUID getStoreId() {
		return this.storeId;
	}

	public void setStoreName(java.lang.String storeName) {
		this.storeName = storeName;
	}
	
	public java.lang.String getStoreName() {
		return this.storeName;
	}

	public void setTempCode(java.lang.String tempCode) {
		this.tempCode = tempCode;
	}
	
	public java.lang.String getTempCode() {
		return this.tempCode;
	}

	public void setTempName(java.lang.String tempName) {
		this.tempName = tempName;
	}
	
	public java.lang.String getTempName() {
		return this.tempName;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	
	public Integer getOrderType() {
		return this.orderType;
	}

	public void setDepotId(java.util.UUID depotId) {
		this.depotId = depotId;
	}
	
	public java.util.UUID getDepotId() {
		return this.depotId;
	}

	public void setDepotName(java.lang.String depotName) {
		this.depotName = depotName;
	}
	
	public java.lang.String getDepotName() {
		return this.depotName;
	}

	public void setSuppId(java.util.UUID suppId) {
		this.suppId = suppId;
	}
	
	public java.util.UUID getSuppId() {
		return this.suppId;
	}

	public void setSuppName(java.lang.String suppName) {
		this.suppName = suppName;
	}
	
	public java.lang.String getSuppName() {
		return this.suppName;
	}

	public void setShipAddress(java.lang.String shipAddress) {
		this.shipAddress = shipAddress;
	}
	
	public java.lang.String getShipAddress() {
		return this.shipAddress;
	}

	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	public BigDecimal getTotalAmt() {
		return this.totalAmt;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus() {
		return this.status;
	}

	public void setCreateUser(java.util.UUID createUser) {
		this.createUser = createUser;
	}
	
	public java.util.UUID getCreateUser() {
		return this.createUser;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setUpdateUser(java.util.UUID updateUser) {
		this.updateUser = updateUser;
	}
	
	public java.util.UUID getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}

	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}
	
	public java.lang.String getRemarks() {
		return this.remarks;
	}

	public List<ScmOrderTempletDetail> getList() {
		return list;
	}

	public void setList(List<ScmOrderTempletDetail> list) {
		this.list = list;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("StoreId",getStoreId())
			.append("StoreName",getStoreName())
			.append("TempCode",getTempCode())
			.append("TempName",getTempName())
			.append("OrderType",getOrderType())
			.append("DepotId",getDepotId())
			.append("DepotName",getDepotName())
			.append("SuppId",getSuppId())
			.append("SuppName",getSuppName())
			.append("ShipAddress",getShipAddress())
			.append("TotalAmt",getTotalAmt())
			.append("Status",getStatus())
			.append("CreateUser",getCreateUser())
			.append("CreateTime",getCreateTime())
			.append("UpdateUser",getUpdateUser())
			.append("UpdateTime",getUpdateTime())
			.append("Remarks",getRemarks())
			.append("TotalQty",getTotalQty())
			.toString();
	}
	
	public Integer getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(Integer totalQty) {
		this.totalQty = totalQty;
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ScmOrderTemplet == false) return false;
		if(this == obj) return true;
		ScmOrderTemplet other = (ScmOrderTemplet)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

