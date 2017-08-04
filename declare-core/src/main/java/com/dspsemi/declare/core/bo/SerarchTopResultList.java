package com.dspsemi.declare.core.bo;

import java.util.Date;


/**
 * 搜索帖子结果列表
 * @author Administrator
 *
 */
public class SerarchTopResultList {
	private Date createTime;
	private String creator;
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 回复数
	 */
	private Integer replyNum;
	/**
	 * 浏览数
	 */
	private Integer visitNum;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(Integer replyNum) {
		this.replyNum = replyNum;
	}
	public Integer getVisitNum() {
		return visitNum;
	}
	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
	}
	
	
}
