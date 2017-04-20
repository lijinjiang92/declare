package com.dspsemi.declare.core.enums;

import com.dspsemi.common.enums.DetailEnum;

public enum JobType implements DetailEnum<Integer>{
	
	STUDENT(0,"学生"),
	MOVE_DEV(1,"移动开发工程师"),
	WEB_DEV(2,"网站开发工程师"),
	NO_DEV(3,"非软件技术员"),
	SELF_EMPLOYED(4,"自由职业"),
	OTHER(9,"其他");
	
	private Integer value;
	private String displayName;
   
    private JobType(Integer value, String display) {
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
