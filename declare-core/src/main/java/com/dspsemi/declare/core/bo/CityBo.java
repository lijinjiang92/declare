package com.dspsemi.declare.core.bo;

import com.dspsemi.common.lang.dto.AbstractBo;

public class CityBo extends AbstractBo {
	
	private static final long serialVersionUID = -8427131374311439119L;
	
	String name;
	String id;	
	String isHot;
	String pinyin;
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
	public String getIsHot() {
		return isHot;
	}
	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	

}
