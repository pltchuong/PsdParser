package com.psdparser.model.layer.additional.effect;

import com.psdparser.model.common.BlendMode;
import com.psdparser.model.layer.additional.EffectLayer;

public class DropShadowInfo extends EffectLayer {

	private Integer blur;
	private Integer Integerensity;
	private Integer angle;
	private Integer distance;
	private String blendModeSignature;
	private BlendMode blendMode;
	private Boolean commonAngle;
	private Integer opacity;
	private String color;
	private String nativeColor;
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
	public Integer getAngle() {
		return angle;
	}
	public void setAngle(Integer angle) {
		this.angle = angle;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public String getBlendModeSignature() {
		return blendModeSignature;
	}
	public void setBlendModeSignature(String blendModeSignature) {
		this.blendModeSignature = blendModeSignature;
	}
	public BlendMode getBlendMode() {
		return blendMode;
	}
	public void setBlendMode(BlendMode blendMode) {
		this.blendMode = blendMode;
	}
	public Boolean isCommonAngle() {
		return commonAngle;
	}
	public void setCommonAngle(Boolean commonAngle) {
		this.commonAngle = commonAngle;
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
	public Boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
}
