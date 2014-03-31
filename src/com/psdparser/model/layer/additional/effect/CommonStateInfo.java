package com.psdparser.model.layer.additional.effect;

import com.psdparser.model.layer.additional.EffectLayer;


public class CommonStateInfo extends EffectLayer {

	private Boolean visible;
	private Integer unused;
	
	public Boolean isVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	public Integer getUnused() {
		return unused;
	}
	public void setUnused(Integer unused) {
		this.unused = unused;
	}
	
}
