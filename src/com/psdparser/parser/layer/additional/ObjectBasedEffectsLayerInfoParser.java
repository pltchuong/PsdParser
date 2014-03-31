package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.ObjectBasedEffectsLayerInfo;
import com.psdparser.parser.common.DescriptorParser;

public class ObjectBasedEffectsLayerInfoParser {

	/**
	 * Object-based effects layer info (Photoshop 6.0)
	 * **/
	
	public static ObjectBasedEffectsLayerInfo parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		ObjectBasedEffectsLayerInfo objectBasedEffectsLayerInfo = new ObjectBasedEffectsLayerInfo();
		objectBasedEffectsLayerInfo.setVersion(dis.readInt());
		objectBasedEffectsLayerInfo.setDescriptorVersion(dis.readInt());
		objectBasedEffectsLayerInfo.setDescriptors(DescriptorParser.parse(dis, cis));
		
		return objectBasedEffectsLayerInfo;
		
	}
	
}
