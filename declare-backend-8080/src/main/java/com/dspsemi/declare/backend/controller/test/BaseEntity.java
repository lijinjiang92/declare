package com.dspsemi.declare.backend.controller.test;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class BaseEntity implements Serializable
{

	private static final long	serialVersionUID	= 1841646150515368881L;
	/**
	 * 主键
	 */
	protected Object			id;

	/**
	 * 餐厅ID
	 */
	protected Object			storeId;

	/**
	 * 餐厅名称
	 */
	protected String			storeName;

	/**
	 * 创建用户ID
	 */
	protected Object			createUser;
	/**
	 * 创建用户名称
	 */
	protected String			createUserName;
	/**
	 * 创建时间
	 */
	protected Date				createTime;
	/**
	 * 更新用户ID
	 */
	protected Object			updateUser;
	/**
	 * 更新时间
	 */
	protected Date				updateTime;

	/**
	 * 作废标识
	 */
	protected Integer			deleteFlag			= 1;

	/**
	 * 租户ID
	 */
	protected Object			tenantId;
	/**
	 * 租户名称
	 */
	protected Object			tenName;

	/**
	 * 列表查询
	 */
	protected String			queryString;

	/**
	 * 是否系统
	 */
	protected Integer			isSystem;

	/**
	 * 删除ID串
	 */
	protected Object[]			delIds;
	protected List<UUID>		delIdsList;
	protected int				page;
	protected int				rows;
	/** 排序属性 */
	protected String			orderProperty;

	/** 排序方向 */
	protected String			orderDirection;

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public Object getStoreId() {
		return storeId;
	}

	public void setStoreId(Object storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Object getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Object createUser) {
		this.createUser = createUser;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Object getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Object updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Object getTenantId() {
		return tenantId;
	}

	public void setTenantId(Object tenantId) {
		this.tenantId = tenantId;
	}

	public Object getTenName() {
		return tenName;
	}

	public void setTenName(Object tenName) {
		this.tenName = tenName;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public Integer getIsSystem() {
		return isSystem;
	}

	public void setIsSystem(Integer isSystem) {
		this.isSystem = isSystem;
	}

	public Object[] getDelIds() {
		return delIds;
	}

	public void setDelIds(Object[] delIds) {
		this.delIds = delIds;
	}

	public List<UUID> getDelIdsList() {
		return delIdsList;
	}

	public void setDelIdsList(List<UUID> delIdsList) {
		this.delIdsList = delIdsList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getOrderProperty() {
		return orderProperty;
	}

	public void setOrderProperty(String orderProperty) {
		this.orderProperty = orderProperty;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}
	
	
	
	


}
