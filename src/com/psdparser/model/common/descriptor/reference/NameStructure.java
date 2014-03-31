package com.psdparser.model.common.descriptor.reference;

import com.psdparser.model.common.descriptor.ReferenceStructure;

public class NameStructure extends ReferenceStructure {

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
