package com.dspsemi.declare.core.enums;

import com.dspsemi.common.enums.DetailEnum;


public enum NoticeType implements DetailEnum<Integer> {
	
	BBS(0, "BBS");
	
	private final Integer value;
	private final String displayName;
	
	private NoticeType(int value, String displayName) {
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
