package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.BlendInteriorElements;

public class BlendInteriorElementsParser {

	/**
	 * Blend interior elements (Photoshop 6.0)
	 * **/
	
	public static BlendInteriorElements parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		BlendInteriorElements blendInteriorElements = new BlendInteriorElements();
		blendInteriorElements.setValue(dis.readBoolean());
		
		return blendInteriorElements;
		
	}
	
}
