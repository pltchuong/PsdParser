package com.psdparser.model.layer.additional;

import com.psdparser.model.layer.AdditionalLayer;

public class LayerOpacity extends AdditionalLayer {

	private Integer opacity;
	
	public Integer getOpacity() {
		return opacity;
	}
	public void setOpacity(Integer opacity) {
		this.opacity = opacity;
	}
	
	@Override
	public String toString() {
		return String.valueOf(opacity);
	}
}
