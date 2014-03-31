package com.psdparser.model.common.descriptor;

import com.psdparser.model.common.Descriptor;

public class UnitFloatDescriptor extends Descriptor {

	private String unit;
	private Integer value;
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value + unit;
	}
}
