package com.psdparser.model.common.descriptor.reference;

import com.psdparser.model.common.descriptor.ReferenceStructure;

public class OffsetStructure extends ReferenceStructure {

	private String name;
	private String classId;
	private Integer value;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return name + "@" + classId;
	}
}
