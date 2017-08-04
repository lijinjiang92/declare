package com.dspsemi.declare.core.bo;

import java.util.List;

/**
 * 前台版块分类Bo
 * @author Administrator
 *
 */
public class SectionClassifyBo {
	/**
	 * 版块分类名称
	 */
	private String name;
	/**
	 * 版块分类id
	 */
	private String id;
	/**
	 * 下面版块
	 */
	private List<SectionBo> sectionBoList;

	public List<SectionBo> getSectionBoList() {
		return sectionBoList;
	}

	public void setSectionBoList(List<SectionBo> sectionBoList) {
		this.sectionBoList = sectionBoList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}
