package com.psdparser.model.layer.additional;

public class EffectLayer {

	private Integer version;
	private String effectSignature;
	private String type;
	private Integer size;
	private Integer subVersion;
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getEffectSignature() {
		return effectSignature;
	}
	public void setEffectSignature(String effectSignature) {
		this.effectSignature = effectSignature;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getSubVersion() {
		return subVersion;
	}
	public void setSubVersion(Integer subVersion) {
		this.subVersion = subVersion;
	}

}
