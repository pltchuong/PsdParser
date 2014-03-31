package com.psdparser.model.common.descriptor.reference;

import com.psdparser.model.common.descriptor.ReferenceStructure;

public class IndexStructure extends ReferenceStructure {

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
