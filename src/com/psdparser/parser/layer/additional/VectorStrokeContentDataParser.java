package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.VectorStrokeContentData;
import com.psdparser.parser.common.DescriptorParser;
import com.psdparser.parser.common.KernelParser;

public class VectorStrokeContentDataParser {

	/**
	 * Vector Stroke Content Data (Photoshop CS6)
	 * **/
	
	public static VectorStrokeContentData parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		VectorStrokeContentData vectorStrokeContentData = new VectorStrokeContentData();
		vectorStrokeContentData.setVectorKey(KernelParser.parseString(dis, cis, 4));
		vectorStrokeContentData.setVersion(dis.readInt());
		vectorStrokeContentData.setDescriptors(DescriptorParser.parse(dis, cis));
		
		return vectorStrokeContentData;
		
	}
	
}
