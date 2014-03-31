package com.psdparser.model.common;

public abstract class Descriptor {

	private String name;
	private String classId;
	private String key;
	private String type;
	private String hex;
	
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
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHex() {
		return hex;
	}
	public void setHex(String hex) {
		this.hex = hex;
	}
	
}
