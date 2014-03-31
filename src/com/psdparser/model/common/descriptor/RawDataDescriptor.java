package com.psdparser.model.common.descriptor;

import java.util.Map;

import com.psdparser.model.common.Descriptor;

public class RawDataDescriptor extends Descriptor {

	private Map<String, Object> properties;
	
	public Map<String, Object> getProperties() {
		return properties;
	}
	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}
	
}
