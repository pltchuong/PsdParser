package com.psdparser.model.layer.additional.effect;

import com.psdparser.model.common.BlendMode;
import com.psdparser.model.layer.additional.EffectLayer;

public class BevelInfo extends EffectLayer {

	private Integer blur;
	private Integer angle;
	private Integer strength;
	private BlendMode highlightBlendMode;
	private BlendMode shadowBlendMode;
	private String highlightColor;
	private String shadowColor;
	private String highlightRealColor;
	private String shadowRealColor;
	private Integer style;
	private Integer highlightOpacity;
	private Integer shadowOpacity;
	private Boolean commonAngle;
	private Boolean up;
	private Boolean enabled;
	
	public Integer getBlur() {
		return blur;
	}
	public void setBlur(Integer blur) {
		this.blur = blur;
	}
	public Integer getAngle() {
		return angle;
	}
	public void setAngle(Integer angle) {
		this.angle = angle;
	}
	public Integer getStrength() {
		return strength;
	}
	public void setStrength(Integer strength) {
		this.strength = strength;
	}
	public BlendMode getHighlightBlendMode() {
		return highlightBlendMode;
	}
	public void setHighlightBlendMode(BlendMode highlightBlendMode) {
		this.highlightBlendMode = highlightBlendMode;
	}
	public BlendMode getShadowBlendMode() {
		return shadowBlendMode;
	}
	public void setShadowBlendMode(BlendMode shadowBlendMode) {
		this.shadowBlendMode = shadowBlendMode;
	}
	public String getHighlightColor() {
		return highlightColor;
	}
	public void setHighlightColor(String highlightColor) {
		this.highlightColor = highlightColor;
	}
	public String getShadowColor() {
		return shadowColor;
	}
	public void setShadowColor(String shadowColor) {
		this.shadowColor = shadowColor;
	}
	public String getHighlightRealColor() {
		return highlightRealColor;
	}
	public void setHighlightRealColor(String highlightRealColor) {
		this.highlightRealColor = highlightRealColor;
	}
	public String getShadowRealColor() {
		return shadowRealColor;
	}
	public void setShadowRealColor(String shadowRealColor) {
		this.shadowRealColor = shadowRealColor;
	}
	public Integer getStyle() {
		return style;
	}
	public void setStyle(Integer style) {
		this.style = style;
	}
	public Integer getHighlightOpacity() {
		return highlightOpacity;
	}
	public void setHighlightOpacity(Integer highlightOpacity) {
		this.highlightOpacity = highlightOpacity;
	}
	public Integer getShadowOpacity() {
		return shadowOpacity;
	}
	public void setShadowOpacity(Integer shadowOpacity) {
		this.shadowOpacity = shadowOpacity;
	}
	public Boolean isCommonAngle() {
		return commonAngle;
	}
	public void setCommonAngle(Boolean commonAngle) {
		this.commonAngle = commonAngle;
	}
	public Boolean isUp() {
		return up;
	}
	public void setUp(Boolean up) {
		this.up = up;
	}
	public Boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
}
