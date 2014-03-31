package com.psdparser.model.common.descriptor.reference;

import com.psdparser.model.common.descriptor.ReferenceStructure;

public class PropertyStructure extends ReferenceStructure {

	private String name;
	private String classId;
	private String keyId;	

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
	public String getKeyId() {
		return keyId;
	}
	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	@Override
	public String toString() {
		return name + "@" + classId + "@" + keyId;
	}
}
