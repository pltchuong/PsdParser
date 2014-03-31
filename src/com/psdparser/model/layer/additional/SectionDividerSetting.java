package com.psdparser.model.layer.additional;

import com.psdparser.model.common.BlendMode;
import com.psdparser.model.layer.AdditionalLayer;

public class SectionDividerSetting extends AdditionalLayer {

	public enum Type {OTHER, FOLDER, BOUNDING}
	
	private Type type;
	private BlendMode blendMode;
	private Integer subType;
	
	public Type getType() {
		return type;
	}
	public void setType(int typeInt) {
		switch (typeInt) {
		case 0:
			type = Type.OTHER;
			break;
		case 1:
		case 2:
			type = Type.FOLDER;
			break;
		case 3:
			type = Type.BOUNDING;
			break;
		}
	}
	public BlendMode getBlendMode() {
		return blendMode;
	}
	public void setBlendMode(BlendMode blendMode) {
		this.blendMode = blendMode;
	}
	public Integer getSubType() {
		return subType;
	}
	public void setSubType(Integer subType) {
		this.subType = subType;
	}
	
}
