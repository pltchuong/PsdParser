package com.psdparser.model.common.descriptor;

import com.psdparser.model.common.Descriptor;

public class IntegerDescriptor extends Descriptor {

	private Integer value;
	
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
