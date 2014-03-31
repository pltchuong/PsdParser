package com.psdparser.model.layer.additional;

import com.psdparser.model.layer.AdditionalLayer;

public class UnicodeLayerName extends AdditionalLayer {

	private String value;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
}
