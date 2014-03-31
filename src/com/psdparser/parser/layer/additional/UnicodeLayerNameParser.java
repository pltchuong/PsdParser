package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.UnicodeLayerName;
import com.psdparser.parser.common.KernelParser;

public class UnicodeLayerNameParser {

	/**
	 * Unicode layer name (Photoshop 5.0)
	 * **/
	
	public static UnicodeLayerName parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		UnicodeLayerName unicodeLayerName = new UnicodeLayerName();
		unicodeLayerName.setValue(KernelParser.parseUnicodeString(dis, cis));
		
		return unicodeLayerName;
	}
	
}
