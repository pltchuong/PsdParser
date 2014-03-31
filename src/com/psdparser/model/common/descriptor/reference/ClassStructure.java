package com.psdparser.model.common.descriptor.reference;

import com.psdparser.model.common.descriptor.ReferenceStructure;

public class ClassStructure extends ReferenceStructure {

	private String name;
	private String classId;

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

	@Override
	public String toString() {
		return name + "@" + classId;
	}
}
