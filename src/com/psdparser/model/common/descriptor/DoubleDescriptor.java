package com.psdparser.model.common.descriptor;

import com.psdparser.model.common.Descriptor;

public class DoubleDescriptor extends Descriptor {

	private Double value;
	
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
