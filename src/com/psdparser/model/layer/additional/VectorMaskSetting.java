package com.psdparser.model.layer.additional;

import java.util.List;

import com.psdparser.model.common.Path;
import com.psdparser.model.layer.AdditionalLayer;

public class VectorMaskSetting extends AdditionalLayer {

	private Integer version;
	private Integer flags;
	private Boolean invert;
	private Boolean notLink;
	private Boolean disable;
	private List<Path> paths;
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getFlags() {
		return flags;
	}
	public void setFlags(Integer flags) {
		this.flags = flags;
	}
	public Boolean isInvert() {
		return invert;
	}
	public void setInvert(Boolean invert) {
		this.invert = invert;
	}
	public Boolean isNotLink() {
		return notLink;
	}
	public void setNotLink(Boolean notLink) {
		this.notLink = notLink;
	}
	public Boolean isDisable() {
		return disable;
	}
	public void setDisable(Boolean disable) {
		this.disable = disable;
	}
	public List<Path> getPaths() {
		return paths;
	}
	public void setPaths(List<Path> paths) {
		this.paths = paths;
	}
	
}
