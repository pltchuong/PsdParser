package com.psdparser.model.layer.additional;

import com.psdparser.model.layer.AdditionalLayer;

public class Exposure extends AdditionalLayer {

	private Integer version;
	private Integer exposure;
	private Integer offset;
	private Integer gamma;
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getExposure() {
		return exposure;
	}
	public void setExposure(Integer exposure) {
		this.exposure = exposure;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getGamma() {
		return gamma;
	}
	public void setGamma(Integer gamma) {
		this.gamma = gamma;
	}
	
}
