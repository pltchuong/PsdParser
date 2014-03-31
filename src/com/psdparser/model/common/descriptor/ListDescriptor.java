package com.psdparser.model.common.descriptor;

import java.util.List;

import com.psdparser.model.common.Descriptor;

public class ListDescriptor extends Descriptor {

	private List<Descriptor> descriptors;

	public List<Descriptor> getDescriptors() {
		return descriptors;
	}
	public void setDescriptors(List<Descriptor> descriptors) {
		this.descriptors = descriptors;
	}
	
}
