package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.ColorLookup;
import com.psdparser.parser.common.DescriptorParser;

public class ColorLookupParser {

	/**
	 * Color Lookup (Photoshop CS6)
	 * **/
	
	public static ColorLookup parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		ColorLookup colorLookup = new ColorLookup();
		colorLookup.setVersion(Integer.valueOf(dis.readShort()));
		colorLookup.setDescriptorVersion(dis.readInt());
		colorLookup.setDescriptors(DescriptorParser.parse(dis, cis));
		
		return colorLookup;
		
	}
		
}
