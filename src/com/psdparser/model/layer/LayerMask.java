package com.psdparser.model.layer;

public class LayerMask {

	private Integer top;
	private Integer left;
	private Integer bottom;
	private Integer right;
	private Integer color;
	private Integer flags;
	private Boolean positionRelativeToLayer;
	private Boolean disabled;
	private Boolean obsolete;
	private Boolean cameFromRenderingOtherData;
	private Boolean haveParametersApplied;
//	private Integer parameters;
	
	public Integer getTop() {
		return top;
	}
	public void setTop(Integer top) {
		this.top = top;
	}
	public Integer getLeft() {
		return left;
	}
	public void setLeft(Integer left) {
		this.left = left;
	}
	public Integer getBottom() {
		return bottom;
	}
	public void setBottom(Integer bottom) {
		this.bottom = bottom;
	}
	public Integer getRight() {
		return right;
	}
	public void setRight(Integer right) {
		this.right = right;
	}
	public Integer getColor() {
		return color;
	}
	public void setColor(Integer color) {
		this.color = color;
	}
	public Integer getFlags() {
		return flags;
	}
	public void setFlags(Integer flags) {
		this.flags = flags;
		
		setPositionRelativeToLayer((flags & 0x01) != 0);
		setDisabled(((flags >> 1) & 0x01) != 0);
		setObsolete(((flags >> 2) & 0x01) != 0);
		setCameFromRenderingOtherData(((flags >> 3) & 0x01) != 0);
		setHaveParametersApplied(((flags >> 4) & 0x01) != 0);
	}
	public Boolean isPositionRelativeToLayer() {
		return positionRelativeToLayer;
	}
	public void setPositionRelativeToLayer(Boolean positionRelativeToLayer) {
		this.positionRelativeToLayer = positionRelativeToLayer;
	}
	public Boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	public Boolean isObsolete() {
		return obsolete;
	}
	public void setObsolete(Boolean obsolete) {
		this.obsolete = obsolete;
	}
	public Boolean isCameFromRenderingOtherData() {
		return cameFromRenderingOtherData;
	}
	public void setCameFromRenderingOtherData(Boolean cameFromRenderingOtherData) {
		this.cameFromRenderingOtherData = cameFromRenderingOtherData;
	}
	public Boolean isHaveParametersApplied() {
		return haveParametersApplied;
	}
	public void setHaveParametersApplied(Boolean haveParametersApplied) {
		this.haveParametersApplied = haveParametersApplied;
	}
	
}
