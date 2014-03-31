package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.ContentGeneratorExtraData;
import com.psdparser.parser.common.DescriptorParser;

public class ContentGeneratorExtraDataParser {

	/**
	 * Content Generator Extra Data (Photoshop CS5)
	 * **/
	
	public static ContentGeneratorExtraData parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		ContentGeneratorExtraData contentGeneratorExtraData = new ContentGeneratorExtraData();
		contentGeneratorExtraData.setDescriptorVersion(dis.readInt());
		contentGeneratorExtraData.setDescriptors(DescriptorParser.parse(dis, cis));
		
		return contentGeneratorExtraData;
		
	}
		
}
