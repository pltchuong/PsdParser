package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.VectorOriginationData;
import com.psdparser.parser.common.DescriptorParser;

public class VectorOriginationDataParser {

	/**
	 * Vector Origination Data (Photoshop CC)
	 * **/
	
	public static VectorOriginationData parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		VectorOriginationData vectorOriginationData = new VectorOriginationData();
		vectorOriginationData.setVersion(dis.readInt());
		vectorOriginationData.setVersion2(dis.readInt());
		vectorOriginationData.setDescriptors(DescriptorParser.parse(dis, cis));
		
		return vectorOriginationData;
		
	}
	
}
