package com.dspsemi.declare.core.enums;

import com.dspsemi.common.enums.DetailEnum;

public enum DevBoardApplyStatus implements DetailEnum<Integer>{
	
	UNPAY(0, "待付款"),
	VERIFYING(1, "待审核"),
	REJECT(2, "驳回"),
	SUC(3, "审核通过"),
	DELIVER(4,"已发货");
	
	private Integer value;
	private String displayName;
   
    private DevBoardApplyStatus(Integer value, String display) {

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
