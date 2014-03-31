package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.VectorStrokeData;
import com.psdparser.parser.common.DescriptorParser;

public class VectorStrokeDataParser {

	/**
	 * Vector Stroke Data (Photoshop CS6)
	 * **/
	
	public static VectorStrokeData parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		VectorStrokeData vectorStrokeData = new VectorStrokeData();
		vectorStrokeData.setVersion(dis.readInt());
		vectorStrokeData.setDescriptors(DescriptorParser.parse(dis, cis));
		
		return vectorStrokeData;
		
	}
	
}
