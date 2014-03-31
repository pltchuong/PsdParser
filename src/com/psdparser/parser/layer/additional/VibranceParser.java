package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.Vibrance;
import com.psdparser.parser.common.DescriptorParser;

public class VibranceParser {

	/**
	 * Vibrance (Photoshop CS3)
	 * **/
	
	public static Vibrance parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		Vibrance vibrance = new Vibrance();
		vibrance.setDescriptorVersion(dis.readInt());
		vibrance.setDescriptors(DescriptorParser.parse(dis, cis));
		
		return vibrance;
		
	}
		
}
