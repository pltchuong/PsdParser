package com.psdparser.model.layer.additional;

import com.psdparser.model.layer.AdditionalLayer;

public class LayerVersion extends AdditionalLayer {

	private Integer version;

	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	@Override
	public String toString() {
		return String.valueOf(version);
	}
	
}
