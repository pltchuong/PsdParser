package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.BlackWhite;
import com.psdparser.parser.common.DescriptorParser;

public class BlackWhiteParser {

	/**
	 * Black White (Photoshop CS3)
	 * **/
	
	public static BlackWhite parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		BlackWhite blackWhite = new BlackWhite();
		blackWhite.setDescriptorVersion(dis.readInt());
		blackWhite.setDescriptors(DescriptorParser.parse(dis, cis));
		
		return blackWhite;
		
	}
		
}
