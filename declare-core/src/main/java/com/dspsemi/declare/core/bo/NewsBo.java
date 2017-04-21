package com.dspsemi.declare.core.bo;

import java.util.Date;

public class NewsBo {
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 内容
	 */
	private String content;
	
	private Date createDate;
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
