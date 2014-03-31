package com.psdparser.model.common.descriptor;

import com.psdparser.model.common.Descriptor;

public class ObjectArray extends Descriptor {

	private String objectType;
	private String objectId;
	private Descriptor value;
	private String data;
	
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String direction) {
		this.objectId = direction;
	}
	public Descriptor getValue() {
		return value;
	}
	public void setValue(Descriptor value) {
		this.value = value;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
