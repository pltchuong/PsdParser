package com.psdparser.model.common.descriptor;

import com.psdparser.model.common.Descriptor;

public class AliasDescriptor extends Descriptor {

	private String value;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
