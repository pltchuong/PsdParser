package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.LayerOpacity;

public class LayerOpacityParser {

	/**
	 * Undocumented
	 * **/
	
	public static LayerOpacity parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		LayerOpacity layerOpacity = new LayerOpacity();
		layerOpacity.setOpacity(dis.readInt());
		
		return layerOpacity;
		
	}
	
}
