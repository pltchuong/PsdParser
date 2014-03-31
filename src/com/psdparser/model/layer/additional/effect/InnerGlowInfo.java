package com.psdparser.model.layer.additional.effect;

import com.psdparser.model.common.BlendMode;
import com.psdparser.model.layer.additional.EffectLayer;

public class InnerGlowInfo extends EffectLayer {

	private Integer blur;
	private Integer Integerensity;
	private BlendMode blendMode;
	private Integer opacity;
	private String color;
	private String nativeColor;
	private Boolean invert;
	private Boolean enabled;
	
	public Integer getBlur() {
		return blur;
	}
	public void setBlur(Integer blur) {
		this.blur = blur;
	}
	public Integer getIntensity() {
		return Integerensity;
	}
	public void setIntensity(Integer Integerensity) {
		this.Integerensity = Integerensity;
	}
	public BlendMode getBlendMode() {
		return blendMode;
	}
	public void setBlendMode(BlendMode blendMode) {
		this.blendMode = blendMode;
	}
	public Integer getOpacity() {
		return opacity;
	}
	public void setOpacity(Integer opacity) {
		this.opacity = opacity;
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
	public Boolean isInvert() {
		return invert;
	}
	public void setInvert(Boolean invert) {
		this.invert = invert;
	}
	public Boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
}
