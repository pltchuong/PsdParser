package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.BlendClippingElements;

public class BlendClippingElementsParser {

	/**
	 * Blend clipping elements (Photoshop 6.0)
	 * **/
	
	public static BlendClippingElements parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		BlendClippingElements blendClippingElements = new BlendClippingElements();
		blendClippingElements.setValue(dis.readBoolean());
		
		return blendClippingElements;
		
	}
	
}
