package com.psdparser.model.common.descriptor;

import com.psdparser.model.common.Descriptor;

public class EnumDescriptor extends Descriptor {

	private String typeId;
	private String value;
	
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return typeId + "@" + value;
	}
}
