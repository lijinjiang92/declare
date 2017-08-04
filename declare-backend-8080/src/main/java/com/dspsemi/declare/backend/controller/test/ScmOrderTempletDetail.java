package com.dspsemi.declare.backend.controller.test;


import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ScmOrderTempletDetail{	
	//columns START
	//主键ID
	private java.util.UUID id;
	//模板ID
	private java.util.UUID billId;
	//机构标识
	private java.util.UUID storeId;
	//序号
	private java.lang.Integer seriNo;
	//物品ID
	private java.util.UUID goodsId;
	//物品名称
	private java.lang.String goodsName;
	//物品规格
	private java.lang.String goodsSpec;
	//主单位ID
	private java.util.UUID unitId;
	//主单位名称
	private java.lang.String unitName;
	//数量
	private BigDecimal goodsQty;
	//金额
	private BigDecimal goodsAmt;
	//单价
	private BigDecimal unitPrice;
	//转换率
	private BigDecimal tranRates;
	//订货单位数量
	private BigDecimal ordUnitQty;
	//订货单位金额
	private BigDecimal ordUnitAmt;
	//订货单位单价
	private BigDecimal ordUnitPrice;
	//订货单位ID
	private java.util.UUID ordUnitId;
	//订货单位名称
	private java.lang.String ordUnitName;
	//备注
	private java.lang.String remarks;
	//类别ID
	private java.util.UUID cateId;
	//类别名称
	private java.lang.String cateName;
	//columns END
	

	public void setId(java.util.UUID id) {
		this.id = id;
	}
	
	public java.util.UUID getId() {
		return this.id;
	}

	public void setBillId(java.util.UUID billId) {
		this.billId = billId;
	}
	
	public java.util.UUID getBillId() {
		return this.billId;
	}

	public void setStoreId(java.util.UUID storeId) {
		this.storeId = storeId;
	}
	
	public java.util.UUID getStoreId() {
		return this.storeId;
	}

	public void setSeriNo(java.lang.Integer seriNo) {
		this.seriNo = seriNo;
	}
	
	public java.lang.Integer getSeriNo() {
		return this.seriNo;
	}

	public void setGoodsId(java.util.UUID goodsId) {
		this.goodsId = goodsId;
	}
	
	public java.util.UUID getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsName(java.lang.String goodsName) {
		this.goodsName = goodsName;
	}
	
	public java.lang.String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsSpec(java.lang.String goodsSpec) {
		this.goodsSpec = goodsSpec;
	}
	
	public java.lang.String getGoodsSpec() {
		return this.goodsSpec;
	}

	public void setUnitId(java.util.UUID unitId) {
		this.unitId = unitId;
	}
	
	public java.util.UUID getUnitId() {
		return this.unitId;
	}

	public void setUnitName(java.lang.String unitName) {
		this.unitName = unitName;
	}
	
	public java.lang.String getUnitName() {
		return this.unitName;
	}

	public void setGoodsQty(BigDecimal goodsQty) {
		this.goodsQty = goodsQty;
	}
	
	public BigDecimal getGoodsQty() {
		return this.goodsQty;
	}

	public void setGoodsAmt(BigDecimal goodsAmt) {
		this.goodsAmt = goodsAmt;
	}
	
	public BigDecimal getGoodsAmt() {
		return this.goodsAmt;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setTranRates(BigDecimal tranRates) {
		this.tranRates = tranRates;
	}
	
	public BigDecimal getTranRates() {
		return this.tranRates;
	}

	public void setOrdUnitQty(BigDecimal ordUnitQty) {
		this.ordUnitQty = ordUnitQty;
	}
	
	public BigDecimal getOrdUnitQty() {
		return this.ordUnitQty;
	}

	public void setOrdUnitAmt(BigDecimal ordUnitAmt) {
		this.ordUnitAmt = ordUnitAmt;
	}
	
	public BigDecimal getOrdUnitAmt() {
		return this.ordUnitAmt;
	}

	public void setOrdUnitPrice(BigDecimal ordUnitPrice) {
		this.ordUnitPrice = ordUnitPrice;
	}
	
	public BigDecimal getOrdUnitPrice() {
		return this.ordUnitPrice;
	}

	public void setOrdUnitId(java.util.UUID ordUnitId) {
		this.ordUnitId = ordUnitId;
	}
	
	public java.util.UUID getOrdUnitId() {
		return this.ordUnitId;
	}

	public void setOrdUnitName(java.lang.String ordUnitName) {
		this.ordUnitName = ordUnitName;
	}
	
	public java.lang.String getOrdUnitName() {
		return this.ordUnitName;
	}

	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}
	
	public java.lang.String getRemarks() {
		return this.remarks;
	}

	public void setCateId(java.util.UUID cateId) {
		this.cateId = cateId;
	}
	
	public java.util.UUID getCateId() {
		return this.cateId;
	}

	public void setCateName(java.lang.String cateName) {
		this.cateName = cateName;
	}
	
	public java.lang.String getCateName() {
		return this.cateName;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("BillId",getBillId())
			.append("StoreId",getStoreId())
			.append("SeriNo",getSeriNo())
			.append("GoodsId",getGoodsId())
			.append("GoodsName",getGoodsName())
			.append("GoodsSpec",getGoodsSpec())
			.append("UnitId",getUnitId())
			.append("UnitName",getUnitName())
			.append("GoodsQty",getGoodsQty())
			.append("GoodsAmt",getGoodsAmt())
			.append("UnitPrice",getUnitPrice())
			.append("TranRates",getTranRates())
			.append("OrdUnitQty",getOrdUnitQty())
			.append("OrdUnitAmt",getOrdUnitAmt())
			.append("OrdUnitPrice",getOrdUnitPrice())
			.append("OrdUnitId",getOrdUnitId())
			.append("OrdUnitName",getOrdUnitName())
			.append("Remarks",getRemarks())
			.append("CateId",getCateId())
			.append("CateName",getCateName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ScmOrderTempletDetail == false) return false;
		if(this == obj) return true;
		ScmOrderTempletDetail other = (ScmOrderTempletDetail)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

