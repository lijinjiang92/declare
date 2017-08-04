package com.dspsemi.declare.core.bo;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.lang.dto.AbstractOperateEntity;

public class BbsSectionListBo extends AbstractOperateEntity  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 排序值
	 */
	private Integer sort;
	
	/**
	 * 版块分类名称
	 */
	private String bbsSectionCtgName;
	
	/**
	 * 主题数
	 */
	private Integer topicNum;
	
	/**
	 * 关注数
	 */
	private Integer concernNum;
	/**
	 * 状态
	 */
	private CloseStatus status;
	
	private Integer id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getBbsSectionCtgName() {
		return bbsSectionCtgName;
	}

	public void setBbsSectionCtgName(String bbsSectionCtgName) {
		this.bbsSectionCtgName = bbsSectionCtgName;
	}

	public Integer getTopicNum() {
		return topicNum;
	}

	public void setTopicNum(Integer topicNum) {
		this.topicNum = topicNum;
	}

	public Integer getConcernNum() {
		return concernNum;
	}

	public void setConcernNum(Integer concernNum) {
		this.concernNum = concernNum;
	}

	public CloseStatus getStatus() {
		return status;
	}

	public void setStatus(CloseStatus status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
