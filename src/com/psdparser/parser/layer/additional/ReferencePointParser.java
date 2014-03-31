package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.ReferencePoint;

public class ReferencePointParser {

	/**
	 * Reference point (Photoshop 6.0)
	 * **/
	
	public static ReferencePoint parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		ReferencePoint referencePoint = new ReferencePoint();
		referencePoint.setReferencePoint1(dis.readDouble());
		referencePoint.setReferencePoint2(dis.readDouble());
		
		return referencePoint;
		
	}
	
}
