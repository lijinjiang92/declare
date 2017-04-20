package com.dspsemi.declare.core.enums;

import com.dspsemi.common.enums.DetailEnum;

public enum DevBoardProType implements DetailEnum<Integer>{
	
	FREE(0,"免费申请"),
	PAID(1,"押金申请");
	
	private Integer value;
	private String displayName;
   
    private DevBoardProType(Integer value, String display) {
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
