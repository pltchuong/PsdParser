package com.psdparser.model.common.descriptor;

import com.psdparser.model.common.Descriptor;

public class UnitDoubleDescriptor extends Descriptor {

	private String unit;
	private Double value;
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value + unit;
	}
}
