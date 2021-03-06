package com.psdparser.model.layer.additional;

import com.psdparser.model.layer.AdditionalLayer;

public class BlendClippingElements extends AdditionalLayer {

	private Boolean value;
	
	public Boolean getValue() {
		return value;
	}
	public void setValue(Boolean value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
