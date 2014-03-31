package com.psdparser.model.layer.additional;

import com.psdparser.model.layer.AdditionalLayer;

public class ReferencePoint extends AdditionalLayer {

	private Double referencePoint1;
	private Double referencePoint2;
	
	public Double getReferencePoint1() {
		return referencePoint1;
	}
	public void setReferencePoint1(Double referencePoint1) {
		this.referencePoint1 = referencePoint1;
	}
	public Double getReferencePoint2() {
		return referencePoint2;
	}
	public void setReferencePoint2(Double referencePoint2) {
		this.referencePoint2 = referencePoint2;
	}
	
}
