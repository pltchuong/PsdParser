package com.psdparser.model.common.descriptor.reference;

import com.psdparser.model.common.descriptor.ReferenceStructure;

public class EnumeratedStructure extends ReferenceStructure {

	private String name;
	private String classId;
	private String typeId;
	private String enumerate;

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
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getEnumerate() {
		return enumerate;
	}
	public void setEnumerate(String enumerate) {
		this.enumerate = enumerate;
	}

	@Override
	public String toString() {
		return name + "@" + classId;
	}
}
