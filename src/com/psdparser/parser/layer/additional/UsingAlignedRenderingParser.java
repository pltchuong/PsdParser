package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.UsingAlignedRendering;

public class UsingAlignedRenderingParser {

	/**
	 * Using Aligned Rendering (Photoshop CS6)
	 * **/
	
	public static UsingAlignedRendering parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		UsingAlignedRendering usingAlignedRendering = new UsingAlignedRendering();
		usingAlignedRendering.setValue(dis.readInt() == 0);
		
		return usingAlignedRendering;
		
	}
	
}
