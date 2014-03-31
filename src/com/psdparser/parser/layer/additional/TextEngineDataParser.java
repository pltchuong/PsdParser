package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.TextEngineData;
import com.psdparser.parser.common.KernelParser;

public class TextEngineDataParser {

	/**
	 * Text Engine Data (Photoshop CS3)
	 * **/
	
	public static TextEngineData parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		TextEngineData textEngineData = new TextEngineData();
		textEngineData.setValue(KernelParser.parseString(dis, cis, dis.readInt()));
		
		return textEngineData;
		
	}
		
}
