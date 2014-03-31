package com.psdparser.model.layer.additional;

import java.util.List;

import com.psdparser.model.common.Descriptor;
import com.psdparser.model.layer.AdditionalLayer;

public class VectorOriginationData extends AdditionalLayer {

	private int version;
	private int version2;
	private List<Descriptor> descriptors;
	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int getVersion2() {
		return version2;
	}
	public void setVersion2(int version2) {
		this.version2 = version2;
	}
	public List<Descriptor> getDescriptors() {
		return descriptors;
	}
	public void setDescriptors(List<Descriptor> descriptors) {
		this.descriptors = descriptors;
	}
	
}
