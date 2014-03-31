package com.psdparser.model.layer.additional;

import java.util.List;

import com.psdparser.model.common.Descriptor;
import com.psdparser.model.layer.AdditionalLayer;

public class VectorStrokeData extends AdditionalLayer {

	private int version;
	private List<Descriptor> descriptors;
	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public List<Descriptor> getDescriptors() {
		return descriptors;
	}
	public void setDescriptors(List<Descriptor> descriptors) {
		this.descriptors = descriptors;
	}
	
}
