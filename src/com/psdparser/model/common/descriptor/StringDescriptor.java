package com.psdparser.model.common.descriptor;

import com.psdparser.model.common.Descriptor;

public class StringDescriptor extends Descriptor {

	private String text;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
