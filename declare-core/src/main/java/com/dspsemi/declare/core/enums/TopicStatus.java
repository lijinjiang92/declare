package com.dspsemi.declare.core.enums;

import com.dspsemi.common.enums.DetailEnum;

public enum TopicStatus implements DetailEnum<Integer>{
	
	NORMAL(0, "新建"),
	USER_DELETE(1, "用户删除"),	//用户删除管理员可见
	MODERATORS_DELETE(2, "版主删除"),	//版主删除管理员可见
	SYS_DELETE(9, "系统删除");    //系统删除所有人不可见
	
	private Integer value;
	private String displayName;
   
    private TopicStatus(Integer value, String display) {

        this.value = value;
        this.displayName = display;
    }
	
	@Override
	public String toString() {
		return "{displayName : '" + displayName + "', value : " + value + "}";
	}
	
	@Override
	public String getDisplayName() {
		return this.displayName;
	}

	@Override
	public String getClassName() {
		return this.name();
	}

	@Override
	public Integer getValue() {
		return this.value;
	}

}
