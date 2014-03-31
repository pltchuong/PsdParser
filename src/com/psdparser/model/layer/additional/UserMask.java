package com.psdparser.model.layer.additional;

import com.psdparser.model.layer.AdditionalLayer;

public class UserMask extends AdditionalLayer {

	private String colorSpace;
	private Integer opacity;
	private Byte flag;

	public String getColorSpace() {
		return colorSpace;
	}
	public void setColorSpace(String colorSpace) {
		this.colorSpace = colorSpace;
	}
	public Integer getOpacity() {
		return opacity;
	}
	public void setOpacity(Integer opacity) {
		this.opacity = opacity;
	}
	public Byte getFlag() {
		return flag;
	}
	public void setFlag(Byte flag) {
		this.flag = flag;
	}
	
}
