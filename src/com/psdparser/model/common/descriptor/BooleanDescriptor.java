package com.psdparser.model.common.descriptor;

import com.psdparser.model.common.Descriptor;

public class BooleanDescriptor extends Descriptor {

	private Boolean value;
	
	public Boolean getValue() {
		return value;
	}
	public void setValue(Boolean value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
