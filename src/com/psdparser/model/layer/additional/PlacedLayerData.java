package com.psdparser.model.layer.additional;

import java.util.List;

import com.psdparser.model.common.Descriptor;
import com.psdparser.model.layer.AdditionalLayer;

public class PlacedLayerData extends AdditionalLayer {

	private String type;
	private Integer plVersion;
	private Integer descriptorVersion;
	private List<Descriptor> descriptors;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPlVersion() {
		return plVersion;
	}
	public void setPlVersion(Integer plVersion) {
		this.plVersion = plVersion;
	}
	public Integer getDescriptorVersion() {
		return descriptorVersion;
	}
	public void setDescriptorVersion(Integer descriptorVersion) {
		this.descriptorVersion = descriptorVersion;
	}
	public List<Descriptor> getDescriptors() {
		return descriptors;
	}
	public void setDescriptors(List<Descriptor> descriptors) {
		this.descriptors = descriptors;
	}
	
}
