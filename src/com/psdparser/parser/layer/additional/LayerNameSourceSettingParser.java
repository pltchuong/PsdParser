package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.LayerNameSourceSetting;

public class LayerNameSourceSettingParser {

	/**
	 * Layer name source setting (Photoshop 6.0)
	 * **/
	
	public static LayerNameSourceSetting parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		LayerNameSourceSetting layerNameSourceSetting = new LayerNameSourceSetting();
		layerNameSourceSetting.setId(dis.readInt());
		
		return layerNameSourceSetting;
		
	}
	
}
