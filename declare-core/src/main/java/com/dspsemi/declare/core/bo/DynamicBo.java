package com.dspsemi.declare.core.bo;

import java.util.Date;

public class DynamicBo {
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 内容
	 */
	private String title;
	
	/**
	 * 发布时间
	 */
	private Date time;
	
	/**
	 * 类型 1：活动2：新闻
	 */
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
