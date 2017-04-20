package com.dspsemi.declare.core.enums;

import com.dspsemi.common.enums.DetailEnum;


public enum ObjType implements DetailEnum<Integer> {
	
	;
	
	private final Integer value;
	private final String displayName;
	
	private ObjType(int value, String displayName) {
		this.value = value;
		this.displayName = displayName;
	}
	
	public Integer getValue() {
		return this.value;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	@Override
	public String toString() {
		return "{displayName : '" + displayName + "', value : " + value + "}";
	}
	
	@Override
	public String getClassName() {
		return this.name();
	}
}
