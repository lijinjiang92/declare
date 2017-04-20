package com.dspsemi.declare.core.enums;

import com.dspsemi.common.enums.DetailEnum;

public enum JobFieldType implements DetailEnum<Integer>{
	
	MOVE_APP(0,"移动应用开发"),
	WEB_BACK(1,"网站后端开发"),
	WEB_FRONT(2,"网站前端开发"),
	PRO_DESIGN(3,"产品设计"),
	OTHER(9,"其他");
	
	private Integer value;
	private String displayName;
   
    private JobFieldType(Integer value, String display) {
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
