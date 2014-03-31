package com.psdparser.model.layer.additional.effect;

import com.psdparser.model.layer.additional.EffectLayer;


public class SolidFill extends EffectLayer {

	private String key;
	private String color;
	private String nativeColor;
	private Integer opacity;
	private Boolean enabled;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNativeColor() {
		return nativeColor;
	}
	public void setNativeColor(String nativeColor) {
		this.nativeColor = nativeColor;
	}
	public Integer getOpacity() {
		return opacity;
	}
	public void setOpacity(Integer opacity) {
		this.opacity = opacity;
	}
	public Boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
}
