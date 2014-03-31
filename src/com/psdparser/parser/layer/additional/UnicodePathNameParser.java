package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.UnicodePathName;
import com.psdparser.parser.common.DescriptorParser;

public class UnicodePathNameParser {

	/**
	 * Unicode Path Name (Photoshop CS6)
	 * **/
	
	public static UnicodePathName parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		UnicodePathName unicodePathName = new UnicodePathName();
		unicodePathName.setDescriptorVersion(dis.readInt());
		unicodePathName.setDescriptors(DescriptorParser.parse(dis, cis));
		
		return unicodePathName;
		
	}
		
}
