package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.LayerVersion;

public class LayerVersionParser {

	/**
	 *  Layer version (Photoshop 7.0) 
	 * **/
	
	public static LayerVersion parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		LayerVersion layerVersion = new LayerVersion();
		layerVersion.setVersion(dis.readInt());
		
		return layerVersion;
		
	}
	
}
